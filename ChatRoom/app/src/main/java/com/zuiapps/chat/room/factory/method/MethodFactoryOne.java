package com.zuiapps.chat.room.factory.method;

import com.zuiapps.chat.room.factory.product.ZUIProductOne;

/**
 * Created by dengshengjin on 15/12/4.
 */
public class MethodFactoryOne {
    public ZUIProductOne product() {
        return new ZUIProductOne();
    }
}
