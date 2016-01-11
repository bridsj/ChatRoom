package com.zuiapps.chat.room.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by dengshengjin on 15/12/22.
 */
public class TimeTest {
    public static void main(String[] args) {

        long clickTime = 0l;
        for (int i = 0; i < 2; i++) {
            if (isToday(convertLongToString(clickTime))) {
                System.out.println("isToday");
                return;
            }
            clickTime = Calendar.getInstance().getTimeInMillis();
            System.out.println("no isToday");
        }
    }

    public static boolean isToday(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        String now = dateFormat.format(Calendar.getInstance().getTime());
        return now.equals(date);
    }

    public static String convertLongToString(long time) {
        Date date = new Date(time);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        return df.format(date);
    }
}
