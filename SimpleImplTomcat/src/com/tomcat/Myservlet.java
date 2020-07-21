package com.tomcat;

import java.io.IOException;

public abstract class Myservlet {
    public final String METHOD_GET="GET";
    public final String METHOD_POST="POST";
    public abstract void  doGet(Request request,Response response) throws IOException;
    public abstract void  doPost(Request request,Response response) throws IOException;
    public void service(Request request,Response response) throws IOException{
        if(METHOD_GET.equals(request.getRequestMethod())){
            doGet(request,response);
        }else if(METHOD_POST.equals(request.getRequestMethod())){
            doPost(request,response);
        }
    }
}
