package com.tomcat;

import java.util.HashMap;

public class Mapping {
    public static HashMap<String,String> hashMap=new HashMap<>();
    //静态代码块 初始化映射关系
    static {
        hashMap.put("/mytomcat","com.tomcat.MyServer");
    }
    public HashMap<String,String> getHashMap(){
        return hashMap;
    }
}
