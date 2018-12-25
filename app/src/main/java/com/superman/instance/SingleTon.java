package com.superman.instance;

/**
 * 作者 Superman
 * 日期 2018/12/25 13:49.
 * 文件 InstanceDemo
 * 描述
 */

public class SingleTon {
    private static SingleTon instance;
    private SingleTon(){}
    public static SingleTon getInstance(){
        if (instance == null) {
            synchronized (SingleTon.class){
                if (instance == null) {
                    instance =new SingleTon();
                }
            }
        }
        return instance;
    }
}
