package com.dolphin.netty.websocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.*;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.util.CharsetUtil;

import java.util.Date;


/**
 * Created by wangjichuan on 2018/9/16.
 */
public class WebSocketServer {

    public void run(int port) throws Exception{
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        ServerBootstrap bootstrap = new ServerBootstrap();

        bootstrap.group(bossGroup,workerGroup)
                .channel(NioServerSocketChannel.class)
                .handler(new LoggingHandler(LogLevel.INFO))
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast("http-codec",
                                new HttpServerCodec())
                                .addLast("aggregator", new HttpObjectAggregator(65536))
                                .addLast("http-chunked", new ChunkedWriteHandler())
                                .addLast("handler", new WebSocketServerHandler());

                    }
                });
        Channel channel = bootstrap.bind(port).sync().channel();
        System.out.println("web socket server started at port :"+port);
        System.out.println("open your browser and navigate to http://localhost:"+port+"/");
//        channel.closeFuture().sync();
//        bossGroup.shutdownGracefully();
//        workerGroup.shutdownGracefully();
    }

    private class WebSocketServerHandler extends SimpleChannelInboundHandler<Object>{
        private WebSocketServerHandshaker handshaker;
        @Override
        protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
            if(msg instanceof FullHttpRequest){
                handleHttpRequest(ctx,(FullHttpRequest) msg);
            }else if(msg instanceof WebSocketFrame){
                handleWebSocketFrame(ctx,(WebSocketFrame) msg);
            }
            System.out.println(msg);
        }

        private void handleHttpRequest(ChannelHandlerContext context,FullHttpRequest fullHttpRequest){
            if(!fullHttpRequest.decoderResult().isSuccess() || !"websocket".equalsIgnoreCase(fullHttpRequest.headers().get("upgrade"))){
                return;
            }
            WebSocketServerHandshakerFactory wsFactory = new WebSocketServerHandshakerFactory("ws://localhost:8081/websocket",null,false);
            handshaker = wsFactory.newHandshaker(fullHttpRequest);
            if(handshaker == null){
                WebSocketServerHandshakerFactory.sendUnsupportedVersionResponse(context.channel());
            }else
            {
                handshaker.handshake(context.channel(),fullHttpRequest);
            }

        }
        private void handleWebSocketFrame(ChannelHandlerContext context,WebSocketFrame frame){
            if(frame instanceof CloseWebSocketFrame){
                handshaker.close(context.channel(),(CloseWebSocketFrame)frame.retain());
                return;
            }
            if(frame instanceof PingWebSocketFrame){
                context.channel().write(new PongWebSocketFrame(frame.content().retain()));
                return;
            }
            if(!(frame instanceof TextWebSocketFrame)){
                throw new UnsupportedOperationException(String.format("%s frame types not sulpported",frame.getClass().getName()));
            }
            String request = ((TextWebSocketFrame) frame).text();
            context.channel().write(new TextWebSocketFrame(request+"欢迎使用netty websocket 服务,现在时刻:"+new Date()));
            context.flush();
        }
    }

    private void sendHttpResponse(ChannelHandlerContext context,FullHttpRequest request,FullHttpResponse response){
        if(response.status().code() != 200){
            ByteBuf buf = Unpooled.copiedBuffer(response.status().toString(), CharsetUtil.UTF_8);
            response.content().writeBytes(buf);
            buf.release();
//            setContentLength(response,response.content().readableBytes());
        }
        ChannelFuture f = context.channel().writeAndFlush(response);
//        if(!isKeepAlive(request) || response.status().code() != 200){
//            f.addListener(ChannelFutureListener.CLOSE);
//        }
    }

    public static void main(String[] args) throws Exception{
        new WebSocketServer().run(8081);
    }


}
