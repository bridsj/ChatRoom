package com.zuiapps.chat.room.annotation;

import java.lang.reflect.Method;

/**
 * Created by dengshengjin on 15/12/4.
 */
public class AnnotationInfo {
    @MethodInfo(auth = "deng@brixd.com")
    public String getName() {
        return "";
    }

    public static void main(String[] args) {
        try {
            Class cls = Class.forName("com.zuiapps.chat.room.annotation.AnnotationInfo");
            for (Method method : cls.getMethods()) {
                MethodInfo methodInfo = method.getAnnotation(MethodInfo.class);
                if (methodInfo != null) {
                    System.out.println("method name:" + method.getName() + "," + methodInfo.auth());
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
