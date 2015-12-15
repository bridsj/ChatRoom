package com.zuiapps.chat.room.sort;

/**
 * Created by dengshengjin on 15/12/11.
 */
public class SortJava implements ISortJava {
    @Override
    public void printArr(int[] intArr) {
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
            if (low < high && intArr[high] >= tmp) {
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
    public int binarySearchSort(int[] intArr, int destValue, int low, int high) {
        if (low <= high) {
            int middle = (low + high) >> 1;
            if (destValue == intArr[middle]) {
                return middle;
            } else if (destValue < intArr[middle]) {
                return binarySearchSort(intArr, destValue, low, middle - 1);
            } else if (destValue > intArr[middle]) {
                return binarySearchSort(intArr, destValue, middle + 1, high);
            }
        }
        return -1;
    }

    @Override
    public void selectSort(int[] intArr) {
        for (int i = 0; i < intArr.length - 1; i++) {
            int min = i;
            for (int j = i; j < intArr.length; j++) {
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
            for (int j = i; j >= 1 && intArr[j] < intArr[j - 1]; j--) {
                int tmp = intArr[j];
                intArr[j] = intArr[j - 1];
                intArr[j - 1] = tmp;
            }
        }
    }

    @Override
    public void shellSort(int[] intArr) {
        int middle = intArr.length;
        int length = intArr.length;
        while (true) {
            middle = (int) Math.ceil(middle / 2.0);
            for (int i = 0; i < middle; i++) {
                for (int j = i; j < length; j = j + middle) {
                    for (int k = j; k >= middle && intArr[k] < intArr[k - middle]; k = k - middle) {
                        int tmp = intArr[k];
                        intArr[k] = intArr[k - middle];
                        intArr[k - middle] = tmp;
                    }
                }
            }
            if (middle == 1) {
                break;
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
        int leftStart = left;
        int rightStart = middle + 1;
        int[] tmp = new int[intArr.length];
        int k = 0;
        while (leftStart <= middle && rightStart <= right) {
            if (intArr[leftStart] < intArr[rightStart]) {
                tmp[k++] = intArr[leftStart++];
            } else {
                tmp[k++] = intArr[rightStart++];
            }
        }
        while (rightStart <= right) {
            tmp[k++] = intArr[rightStart++];
        }
        while (leftStart <= middle) {
            tmp[k++] = intArr[leftStart++];
        }
        for (int i = 0; i < k; i++) {
            intArr[left + i] = tmp[i];
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
                        k++;
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
