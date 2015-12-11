package com.zuiapps.chat.room.factory.abstr;

/**
 * Created by dengshengjin on 15/12/4.
 */
public abstract class AbstractBaseFactory {
    public abstract ZUIBaseTextProduct createTextProduct();

    public abstract ZUIBaseImageProduct createImageProduct();
}
