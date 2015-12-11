package com.zuiapps.chat.room.invoke;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by dengshengjin on 15/12/4.
 */
public class InvokeAdapter {
    public static void main(String[] args) {
        InvokeInterface invokeInterface = (InvokeInterface) new InvokeAdapter().createInvokeInterface(new InvokeObject());
        invokeInterface.invokeRun();
    }

    public Object createInvokeInterface(Object object) {
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), new InvokeInvocationHandler(object));
    }

    class InvokeInvocationHandler implements InvocationHandler {
        private Object cls;

        public InvokeInvocationHandler(Object cls) {
            this.cls = cls;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            //intercept
            return method.invoke(cls, args);
        }
    }
}
