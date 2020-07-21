package com.tomcat;

import java.io.IOException;
import java.io.InputStream;

public class Request {
    private String requestMethod;
    private String requestUrl;

    public Request(InputStream inputStream) throws IOException {
     byte[] bytes=new byte[1024];
     String str="";
     int len=0;
     //获取请求头信息
     if((len=inputStream.read(bytes))>0){
         str=new String(bytes,0,len);
     }
     //请求行信息 GET /URL
        String requestLine = str.split("\n")[0];
        String[] datas = requestLine.split(" ");
        requestMethod=datas[0];
        requestUrl=datas[1];
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }
}
