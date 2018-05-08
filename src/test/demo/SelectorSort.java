package test.demo;

import java.util.Arrays;

/**
 * 原理：
 *      将数据划分为两部分，一部分有序，一部分无序
 *      每一次从待排序的数据元素中选出最小（或最大）的一个元素，存放在序列的起始位置，直到全部待排序的数据元素排完。
 *      选择排序是不稳定的排序方法
 *
 * 11,3,5,4,9,6,8,7
 * 3,11,5,4,9,6,8,7
 * 3,5,11,4,9,6,8,7
 * 3,4,11,5,9,6,8,7
 */
public class SelectorSort {
    public static void main(String[] args) {
        int[] arr = {11, 3, 5, 4, 9, 6, 8, 7, 88, 66, 68, 55};
        System.out.println(Arrays.toString(arr));
        selectorSort(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr1 = {11, 3, 5, 4, 9, 6, 8, 7, 88, 66, 68, 55};
        System.out.println(Arrays.toString(arr1));
        selectorSortDESC(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    public static void selectorSortDESC(int[] arr) {
        int max;

        for (int i = 0; i < arr.length - 1; i++) {
            max = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[max] < arr[j]) {
                    int temp = arr[max];
                    arr[max] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void selectorSort(int[] arr) {
        //一部分排序，另一部分无序
        int min;

        for (int i = 0; i < arr.length - 1; i++) {
            min = i;
            //每一次的最小值,都放在最小值位置
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    int temp = arr[min];
                    arr[min] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
