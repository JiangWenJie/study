package com.jwj.study.netty.ch4;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * @Author: jwj
 * @Date: 2020/7/15 14:33
 * @Description: TODO
 */
public class PlainOioServer {
    public void server(int port) throws IOException {
        final ServerSocket socket=new ServerSocket(port);
        for (;;){
            final Socket clientSocket=socket.accept();
            System.out.println("Accepted connection from "+clientSocket);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    OutputStream out;
                    try {
                        out=clientSocket.getOutputStream();
                        out.write("Hi!\r\n".getBytes(Charset.forName("UTF-8")));
                        out.flush();
                        clientSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }finally {
                        try {
                            clientSocket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }
}
