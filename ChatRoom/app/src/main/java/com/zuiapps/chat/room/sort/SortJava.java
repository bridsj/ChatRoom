package com.zuiapps.chat.room.sort;

/**
 * Created by dengshengjin on 15/12/11.
 */
public class SortJava implements ISortJava {

    @Override
    public void println(int[] intArr) {
        for (int intValue : intArr) {
            System.out.print(intValue + ",");
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
    public int binarySearch(int[] intArr, int destValue, int low, int high) {
        if (low <= high) {
            int middle = (low + high) >> 1;
            if (destValue == intArr[middle]) {
                return middle;
            } else if (destValue < intArr[middle]) {
                return binarySearch(intArr, destValue, low, middle - 1);
            } else if (destValue > intArr[middle]) {
                return binarySearch(intArr, destValue, middle + 1, high);
            }
        }
        return -1;
    }

    @Override
    public void insertSort(int[] intArr) {
        for (int i = 0; i < intArr.length; i++) {
            for (int j = i; j >= 1 && intArr[j] < intArr[j - 1]; j--) {//Bug
                int tmp = intArr[j];
                intArr[j] = intArr[j - 1];
                intArr[j - 1] = tmp;
            }
        }
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
                int tmp = intArr[i];
                intArr[i] = intArr[min];
                intArr[min] = tmp;
            }
        }
    }

    @Override
    public void mergeSort(int[] intArr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(intArr, left, middle);
            mergeSort(intArr, middle + 1, right);
            merge(intArr, left, middle, right);
        }
    }

    private void merge(int[] intArr, int left, int middle, int right) {
        int[] tmp = new int[intArr.length];
        int leftIndex = left;
        int rightIndex = middle + 1;
        int k = 0;
        while (leftIndex <= middle && rightIndex <= right) {
            if (intArr[leftIndex] < intArr[rightIndex]) {
                tmp[k++] = intArr[leftIndex++];
            } else {
                tmp[k++] = intArr[rightIndex++];
            }
        }
        while (rightIndex <= right) {
            tmp[k++] = intArr[rightIndex++];
        }
        while (leftIndex <= middle) {
            tmp[k++] = intArr[leftIndex++];
        }
        for (int i = 0; i < k; i++) {
            intArr[left + i] = tmp[i];
        }
    }

    @Override
    public void shellSort(int[] intArr) {
        int length = intArr.length;
        int middle = intArr.length;
        while (true) {
            middle = (int) Math.ceil(middle / 2);
            for (int i = 0; i < middle; i++) {
                for (int j = middle + i; j < length; j = j + middle) {
                    for (int k = j; k >= middle && intArr[k] < intArr[k - middle]; k = k - middle) {
                        int tmp = intArr[k];
                        intArr[k] = intArr[k - middle];
                        intArr[k - middle] = tmp;//bug
                    }
                }
            }
            if (middle == 1) {
                break;
            }
        }
    }

    @Override
    public void radixSort(int[] intArr, int maxDigit) {
        int n = 1;
        int length = intArr.length;
        if (length < 10) {
            length = 10;
        }
        while (n <= maxDigit) {
            int[][] bucket = new int[10][length];
            int[] order = new int[length];
            for (int intValue : intArr) {
                int digit = (intValue / n) % 10;
                bucket[digit][order[digit]] = intValue;
                order[digit]++;
            }
            int k = 0;
            for (int i = 0; i < 10; i++) {
                if (order[i] != 0) {
                    for (int j = 0; j < order[i]; j++) {
                        intArr[k] = bucket[i][j];
                        k = k + 1;
                    }
                }
            }
            n = n * 10;
        }
    }

    @Override
    public void heapSort(int[] intArr) {

    }


}
