package com.zuiapps.chat.room.factory.simple;

import com.zuiapps.chat.room.factory.product.ZUIBaseProduct;
import com.zuiapps.chat.room.factory.product.ZUIProductOne;
import com.zuiapps.chat.room.factory.product.ZUIProductTwo;

/**
 * Created by dengshengjin on 15/12/4.
 */
public class SimpleFactory {

    public ZUIBaseProduct product(int type) {
        ZUIBaseProduct zuiBaseProduct = null;
        switch (type) {
            case 1:
                zuiBaseProduct = new ZUIProductOne();
                break;
            case 2:
                zuiBaseProduct = new ZUIProductTwo();
                break;
            default:
                break;
        }
        return zuiBaseProduct;
    }
}
