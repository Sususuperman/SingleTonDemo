package com.superman.instance;

/**
 * 作者 Superman
 * 日期 2019/3/19 13:58.
 * 文件 InstanceDemo
 * 描述
 */

public class SingleTon2 {
    private static SingleTon2 singleTon2;

    private SingleTon2() {
    }
    private static SingleTon2 getInstance() {
        if (singleTon2 == null) {
            synchronized (SingleTon2.class) {
                if (singleTon2 == null) {
                    singleTon2 = new SingleTon2();
                }
            }
        }
        return singleTon2;
    }
}
