package com.zuiapps.chat.room.sort;

import org.wltea.expression.ExpressionEvaluator;


/**
 * Created by dengshengjin on 15/12/11.
 */
public class SortTest implements Cloneable {

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        int[] intArr = {10, 52, 14, 8, 48, 9, 61, 78, 45, 31};
        int length = intArr.length;
        SortJava sortJava = new SortJava();
        System.out.print("source:");
        sortJava.println(intArr);
        //bubble
        int[] bubbleArr = intArr.clone();
        sortJava.bubbleSort(bubbleArr);
        System.out.print("bubble:");
        sortJava.println(bubbleArr);
        //quick
        int[] quickArr = intArr.clone();
        sortJava.quickSort(quickArr, 0, length - 1);
        System.out.print("quick0:");
        sortJava.println(quickArr);
        //binary search
        System.out.println("binarySearch:" + sortJava.binarySearch(quickArr, 52, 0, length));
        //select
        int[] selectArr = intArr.clone();
        sortJava.selectSort(selectArr);
        System.out.print("select:");
        sortJava.println(selectArr);
        //insert
        int[] insertArr = intArr.clone();
        sortJava.insertSort(insertArr);
        System.out.print("insert:");
        sortJava.println(insertArr);
        //shell
        int[] shellArr = intArr.clone();
        sortJava.shellSort(shellArr);
        System.out.print("shell0:");
        sortJava.println(shellArr);
        //shell
        int[] mergeArr = intArr.clone();
        sortJava.mergeSort(mergeArr, 0, length - 1);
        System.out.print("merge0:");
        sortJava.println(mergeArr);
        //radix
        int[] radixArr = intArr.clone();
        sortJava.radixSort(radixArr, 100);
        System.out.print("radix0:");
        sortJava.println(radixArr);

        String r = "10*n+1";
        int n = 5;
        r = r.replace("n", n + "");
        System.out.println(ExpressionEvaluator.evaluate(r));

        new SortTest().clone();
    }
}
