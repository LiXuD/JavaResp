package com.tomcat;

import java.io.IOException;
import java.io.OutputStream;

public class Response {
    private OutputStream outputStream;

    public Response(OutputStream outputStream) {
        this.outputStream=outputStream;
    }
    public void write(String str) throws IOException {
        StringBuilder sb=new StringBuilder();
        sb.append("HTTP/1.1 200 OK\n")
                .append("Content-Type:text/html\n")
                .append("\r\n")
                .append("<html><body><h1>"+str+"</h1></body></html>");
        System.out.println(sb.toString());
        outputStream.write(sb.toString().getBytes());
        outputStream.flush();
        outputStream.close();
    }
}
