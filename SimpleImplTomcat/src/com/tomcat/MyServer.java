package com.tomcat;

import java.io.IOException;

public class MyServer extends Myservlet {
    @Override
    public void doGet(Request request, Response response) throws IOException {
        response.write("doGet for my SimpleImplTomcat");
    }

    @Override
    public void doPost(Request request, Response response) throws IOException {
        response.write("doPost for my SimpleImplTomcat");
    }
}
