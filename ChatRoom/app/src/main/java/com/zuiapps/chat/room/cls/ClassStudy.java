package com.zuiapps.chat.room.cls;

/**
 * Created by dengshengjin on 15/12/10.
 */
public class ClassStudy {

    static {
        System.out.println("static block");//属于类的内存，存在方法区中
    }

    {
        System.out.println("common block");//创建对象才执行,存在 堆
    }

    public ClassStudy() {
        System.out.println("construction");
    }//创建对象才执行,存在 堆

    public static void main(String[] args) {
        new ClassStudy();

    }
}
