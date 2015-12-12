package com.zuiapps.chat.room.sort;

/**
 * Created by dengshengjin on 15/12/11.
 */
public class SortTest {
    public static void main(String[] args) {
//        int[] sourceArr = {9, 5, 6, 12, 7, 8, 1};
        int[] sourceArr = {26, 5, 98, 108, 28, 99, 100, 56, 34, 1};
        int length = sourceArr.length;
        SortJava sortJava = new SortJava();

        System.out.println("bubble:");
        int[] bubbleArr = sourceArr.clone();
        sortJava.printArr(bubbleArr);
        sortJava.bubbleSort(bubbleArr);
        sortJava.printArr(bubbleArr);

        System.out.println();
        System.out.println("quick:");
        int[] quickArr = sourceArr.clone();
        sortJava.printArr(quickArr);
        sortJava.quickSort(quickArr, 0, length - 1);
        sortJava.printArr(quickArr);

        System.out.println();
        System.out.println("select:");
        int[] selectArr = sourceArr.clone();
        sortJava.printArr(selectArr);
        sortJava.selectSort(selectArr);
        sortJava.printArr(selectArr);

        System.out.println();
        System.out.println("insert:");
        int[] insertArr = sourceArr.clone();
        sortJava.printArr(insertArr);
        sortJava.insertSort(insertArr);
        sortJava.printArr(insertArr);

        System.out.println();
        System.out.println("merge:");
        int[] mergeArr = sourceArr.clone();
        sortJava.printArr(mergeArr);
        sortJava.mergeSort(mergeArr, 0, length - 1);
        sortJava.printArr(mergeArr);

        System.out.println();
        System.out.println("radix:");
        int[] radixArr = sourceArr.clone();
        sortJava.printArr(radixArr);
        sortJava.radixSort(radixArr, 100);
        sortJava.printArr(radixArr);

        System.out.println();
        System.out.println("shell:");
        int[] shellArr = sourceArr.clone();
        sortJava.printArr(shellArr);
        sortJava.shellSort(shellArr);
        sortJava.printArr(shellArr);

        System.out.println();
        System.out.println("heap:");
        int[] heapArr = sourceArr.clone();
        sortJava.printArr(heapArr);
        sortJava.heapSort(heapArr);
        sortJava.printArr(heapArr);

        System.out.println();
        System.out.println("binarySearch:");
        sortJava.printArr(bubbleArr);
        int searchNum = 108;
        System.out.println(searchNum + "在某个位置=" + sortJava.binarySearchSort(bubbleArr, searchNum, 0, length));

    }
}
