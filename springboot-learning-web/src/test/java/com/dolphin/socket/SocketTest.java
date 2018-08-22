package com.dolphin.socket;

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/** 普通阻塞的io
 * @author jichuan.wang
 * @<p>:
 * @since 2018/8/17 16:56
 */
public class SocketTest {

    @Test
    public void test01() throws Exception{
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true){
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            while (true){
                String lineStr = reader.readLine();
                System.out.println(lineStr);
                OutputStream outputStream = socket.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
                writer.write("哈哈");
                writer.flush();
//                writer.close();
            }
        }
    }
}
