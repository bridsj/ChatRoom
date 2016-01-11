package com.zuiapps.chat.room.bit;

/**
 * Created by dengshengjin on 15/12/13.
 */
public class BitOperate {
    public static void main(String[] args) {
        System.out.println(1 | 0);//1
        System.out.println(0 | 1);//1
        System.out.println(1 | 1);//1
        System.out.println(0 | 0);//0
        System.out.println();

        System.out.println(1 & 0);//0
        System.out.println(0 & 1);//0
        System.out.println(1 & 1);//1
        System.out.println(0 & 0);//0
        System.out.println();

        System.out.println(1 ^ 0);//1
        System.out.println(0 ^ 1);//1
        System.out.println(1 ^ 1);//0
        System.out.println(0 ^ 0);//0
        System.out.println();

        System.out.println(~0);//1
        System.out.println(~1);//0
        System.out.println();

        System.out.println(Math.sqrt(9));//3.0
        System.out.println(Math.ceil(4.6));//5.0
        System.out.println(Math.ceil(4.1));//5.0
        System.out.println(Math.floor(5.1));//5.0
        System.out.println(Math.floor(5.7));//5.0
        System.out.println(Math.round(5.1));//5.0
        System.out.println(Math.round(5.6));//6.0
        System.out.println(Math.pow(3, 3));//27.0
        System.out.println();

        System.out.println(1 << 0);//1*2=2
        System.out.println(8 >> 2);//8/(2的2次方)=8/4=2
        System.out.println();
        final long DOWNLOAD_MAX_BYTES_OVER_MOBILE = 2 * 1024 * 1024 * 1024;
        System.out.println(DOWNLOAD_MAX_BYTES_OVER_MOBILE);
        boolean allowAllNetworkTypes = false;
        int flag = 1;
        int mAllowedNetworkTypes = 3;
        System.out.println(!allowAllNetworkTypes && (flag & mAllowedNetworkTypes) == 0);
        if (!allowAllNetworkTypes && (flag & mAllowedNetworkTypes) == 0) {

        }
    }


}
