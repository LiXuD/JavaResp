package com.tomcat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketImpl {
    public static void startSocket(int port) throws Exception {
        ServerSocket serverSocket = new ServerSocket(port);
        Socket socket=null;
        while (true){
            socket=serverSocket.accept();
            OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();
            Request request = new Request(inputStream);
            Response response = new Response(outputStream);

            //获取映射关系
            String clazz=new Mapping().getHashMap().get(request.getRequestUrl());
            if(clazz!=null){
                //反射 加载 调用
                Class<Myservlet> aClass = (Class<Myservlet>) Class.forName(clazz);
                Myservlet myservlet = aClass.getDeclaredConstructor().newInstance();
                myservlet.service(request,response);
            }
        }

    }

    public static void main(String[] args) {
        try {
            startSocket(8080);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
