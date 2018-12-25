package com.superman.instance;

/**
 * 作者 Superman
 * 日期 2018/12/25 10:56.
 * 文件 InstanceDemo
 * 描述 写一个单例的条件
 * 1、构造函数私有 2、含有一个该类的静态私有对象 3、有一个静态的公有的函数用于创建或获取它本身的静态私有对象
 * 4、其次才是考虑线程同步！
 */

public class MyInstance {
    private static  MyInstance instance;//静态私有对象
    private MyInstance(){};//构造函数

    //静态公有方法，用于创建或者获取
    public static MyInstance getInstance1(){//未考虑线程同步，线程多并发的时候，不提倡。
        if (instance == null) {
            instance = new MyInstance();
        }
        return instance;
    }

    //方法加锁同步
    //这种代码下，每条线程都会依次进入方法块内部，虽然实现了单例，但是影响了运行效率，可以使用但是也不怎么提倡。
    public static synchronized MyInstance getInstance2(){
        if (instance == null) {
            instance = new MyInstance();
        }
        return instance;
    }

    //双重判断加锁，效率影响小而且保证了线程安全。
    public static  MyInstance getInstance3(){
        if (instance == null) {
            synchronized (MyInstance.class){
                if (instance == null) {
                    instance = new MyInstance();
                }
        }
        }

        return instance;

    }
}
