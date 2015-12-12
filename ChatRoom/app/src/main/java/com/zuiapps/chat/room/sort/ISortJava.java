package com.zuiapps.chat.room.sort;

/**
 * Created by dengshengjin on 15/12/11.
 */
public interface ISortJava {

    void printArr(int[] intArr);

    void bubbleSort(int[] intArr);

    void quickSort(int[] intArr, int low, int high);

    int binarySearchSort(int[] intArr, int destValue, int low, int high);

    void selectSort(int[] intArr);

    void insertSort(int[] intArr);

    void shellSort(int[] intArr);

    void mergeSort(int[] intArr, int left, int right);

    void radixSort(int[] intArr,int maxDigit);

    void heapSort(int[] intArr);


}
