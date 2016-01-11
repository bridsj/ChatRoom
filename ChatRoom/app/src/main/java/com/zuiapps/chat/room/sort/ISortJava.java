package com.zuiapps.chat.room.sort;

/**
 * Created by dengshengjin on 15/12/11.
 */
public interface ISortJava {
    void println(int[] intArr);

    void bubbleSort(int[] intArr);

    void quickSort(int[] intArr, int low, int high);

    int binarySearch(int[] intArr, int destValue, int low, int high);

    void insertSort(int[] intArr);

    void selectSort(int[] intArr);

    void mergeSort(int[] intArr, int left, int right);

    void shellSort(int[] intArr);

    void radixSort(int[] intArr,int maxDigit);

    void heapSort(int[] intArr);
}
