package com.doubleriver.design.patterns;


import java.util.logging.Logger;

/**
 * @Author ronye
 * @Created 2018/12/4 - 4:06 PM
 */
public class Singleton {
    Logger logger = Logger.getLogger(this.getClass().getName());
    //1-只有私有方法才能控制不被外部类所调用呢
    private Singleton(){

    }
    //2-如果外部不能调用构造方法，只能自己来调用构造起
    private static Singleton singleton = new Singleton();//懒汉式
    //private static Singleton singleton = null;

    //3-外部通过类的公有方法来调用获取实例，通过类来调用则该方法也必须是static
    public  static Singleton getInstance(){
        return singleton;
        //懒汉式,存在线程安全问题
//        if(singleton == null){
//            singleton = new Singleton();
//        }
//        return singleton;
    }

    public static void main(String[] args) {

        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        System.out.println(s1 == s2);
    }
}
