package com.zuiapps.chat.room.cls;

/**
 * Created by dengshengjin on 15/12/10.
 */
public class ClassStudy {

    static {
        System.out.println("static block");
    }

    {
        System.out.println("common block");
    }

    public ClassStudy() {
        System.out.println("construction");
    }

    public static void main(String[] args) {
        new ClassStudy();

    }
}
