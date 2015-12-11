package com.zuiapps.chat.room.factory.abstr;

/**
 * Created by dengshengjin on 15/12/4.
 */
public class AbstractTwoOneFactory extends AbstractBaseFactory {
    @Override
    public ZUIBaseTextProduct createTextProduct() {
        return new ZUITwoTextProduct();
    }

    @Override
    public ZUIBaseImageProduct createImageProduct() {
        return new ZUIOneImageProduct();
    }
}
