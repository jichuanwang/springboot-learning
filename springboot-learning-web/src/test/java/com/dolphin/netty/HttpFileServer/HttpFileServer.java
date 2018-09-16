package com.dolphin.netty.HttpFileServer;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.*;
import io.netty.handler.stream.ChunkedWriteHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;


/**
 * Created by wangjichuan on 2018/9/14.
 */
public class HttpFileServer {

    private static final String DEFAULT_URL = "/src/com/phei/netty";

//    public void run(final int port,final String url) throws Exception{
//        EventLoopGroup bossGroup = new NioEventLoopGroup();
//        EventLoopGroup workerGroup = new NioEventLoopGroup();
//        ServerBootstrap bootstrap = new ServerBootstrap();
//        bootstrap.group(bossGroup,workerGroup)
//                .channel(NioServerSocketChannel.class)
//                .childHandler(new ChannelInitializer<SocketChannel>() {
//                    @Override
//                    protected void initChannel(SocketChannel socketChannel) throws Exception {
//                        socketChannel.pipeline().addLast(new HttpRequestDecoder());
//                        socketChannel.pipeline().addLast("http-aggregator",
//                                new HttpObjectAggregator(65536));
//                        socketChannel.pipeline().addLast("http-encoder",
//                                new HttpResponseEncoder());
//                        socketChannel.pipeline().addLast("http-chunked",
//                                new ChunkedWriteHandler());
//                        socketChannel.pipeline().addLast("fileServerHandler",
//                                new HttpFileServerHandler(url));
//                    }
//                });
//    }
//
//    private class HttpFileServerHandler extends SimpleChannelInboundHandler<FullHttpRequest>{
//
//        private void sendError(ChannelHandlerContext context,String code){
//
//        }
//        @Override
//        protected void channelRead0(ChannelHandlerContext channelHandlerContext, FullHttpRequest fullHttpRequest) throws Exception {
//            if(!fullHttpRequest.decoderResult().isSuccess()){
//                sendError(channelHandlerContext,METHOD_NOT_ALLOWED);
//            }
//            if(fullHttpRequest.method() != HttpMethod.GET){
//                sendError(channelHandlerContext,"METHOD_NOT_ALLOWED");
//            }
//            final String uri = fullHttpRequest.uri();
//            final String path = senitizeUrl(uri);
//            if(path == null){
//                sendError(channelHandlerContext,"FORBIDDEN");
//                return;
//            }
//            File file = new File(path);
//            if(file.isHidden() || !file.exists()){
//                sendError(channelHandlerContext,"NOT_FOUND");
//                return;
//            }
//            if(!file.isFile()){
//                sendError(channelHandlerContext,"FORBIDDEN");
//                return;
//            }
//            RandomAccessFile randomAccessFile = null;
//            try {
//                randomAccessFile = new RandomAccessFile(file,"r");
//            }catch (FileNotFoundException fnfe){
//                sendError(channelHandlerContext,"NOT_FOUND");
//                return;
//            }
//            long fileLength = randomAccessFile.length();
//            HttpResponse response = new DefaultHttpResponse(HttpVersion.HTTP_1_1,HttpResponseStatus.OK);
//            setContentLength(response,fileLength);
//            setContentTypeHeader(response,file);
//            if(isKeepLive(fullHttpRequest)){
//                response.headers().set()
//            }
//        }
//    }
//    private String senitizeUrl(String uri){
//        return null;
//    }
}
