package com.zuiapps.chat.room.sort;

/**
 * Created by dengshengjin on 15/12/11.
 */
public class SortJava implements ISortJava {

    @Override
    public void printArr(int[] intArr) {
        for (int value : intArr) {
            System.out.print(value + ",");
        }
        System.out.println();
    }

    @Override
    public void bubbleSort(int[] intArr) {
        for (int i = 0; i < intArr.length - 1; i++) {
            for (int j = i + 1; j < intArr.length; j++) {
                if (intArr[j] < intArr[i]) {
                    int tmp = intArr[j];
                    intArr[j] = intArr[i];
                    intArr[i] = tmp;
                }
            }
        }
    }

    @Override
    public void quickSort(int[] intArr, int low, int high) {
        if (low < high) {
            int middle = getMiddle(intArr, low, high);
            quickSort(intArr, low, middle - 1);
            quickSort(intArr, middle + 1, high);
        }
    }

    private int getMiddle(int[] intArr, int low, int high) {
        int tmp = intArr[low];
        while (low < high) {
            while (low < high && intArr[high] >= tmp) {
                high--;
            }
            intArr[low] = intArr[high];
            while (low < high && intArr[low] <= tmp) {
                low++;
            }
            intArr[high] = intArr[low];
        }
        intArr[low] = tmp;
        return low;
    }


    @Override
    public void selectSort(int[] intArr) {
        for (int i = 0; i < intArr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < intArr.length; j++) {
                if (intArr[j] < intArr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int tmp = intArr[min];
                intArr[min] = intArr[i];
                intArr[i] = tmp;
            }
        }
    }

    @Override
    public void insertSort(int[] intArr) {
        for (int i = 0; i < intArr.length; i++) {
            for (int j = i; j > 0 && intArr[j] < intArr[j - 1]; j--) {
                int tmp = intArr[j];
                intArr[j] = intArr[j - 1];
                intArr[j - 1] = tmp;
            }
        }
    }

    @Override
    public void mergeSort(int[] intArr, int left, int right) {

    }

    @Override
    public void radixSort(int[] intArr) {

    }

    @Override
    public void shellSort(int[] intArr) {


    }

    @Override
    public void heapSort(int[] intArr) {

    }

    @Override
    public int binarySearchSort(int[] intArr, int destValue, int low, int high) {//适用有序列表
        if (low <= high) {
            int middle = (low + high) >>> 1;
            if (destValue == intArr[middle]) {
                return middle;
            } else if (destValue < intArr[middle]) {
                return binarySearchSort(intArr, destValue, low, middle - 1);
            } else if (destValue > intArr[middle]) {
                return binarySearchSort(intArr, destValue, middle + 1, high);
            }
        } else {
            return -1;
        }
        return -1;


    }
}
