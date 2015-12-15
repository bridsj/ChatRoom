package com.zuiapps.chat.room.innerCls;

/**
 * Created by dengshengjin on 15/12/15.
 */
public class InnerClass {
    class InnerTest {
        InnerClass getInnerClass() {
            return InnerClass.this;
        }
    }


    final static class InnerStaticTest {//声明成静态内部类（嵌套内部类）为了去除与外部类的引用 ,除此区别与普通内部类没有任何区别
        //防止内存溢出,相当于直接创建一个正常的InnerStaticTest.java 文件

        public void display() {

        }
    }

    public void display() {

    }

    public static void main(String[] args) {
        InnerClass innerClass = new InnerClass();
        InnerTest innerTest = innerClass.new InnerTest();
        innerClass.display();
        innerTest.getInnerClass().display();

        InnerStaticTest innerStaticTest = new InnerStaticTest();
        innerStaticTest.display();
    }
}
