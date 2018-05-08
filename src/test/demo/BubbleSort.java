package test.demo;

import java.util.Arrays;

/**
 * 冒泡排序
 *      比较两个相邻的元素，将值大的元素交换至右端。
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {22,55,23,4,7,6,9,3,99,44,33,55,221};
        System.out.println(Arrays.toString(arr));
        bubbleSortAES(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr));
        bubbleSortDESC(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSortAES(int[] arr){

        for (int i = 0; i < arr.length-1; i++) {//控制比较的轮数   length-1轮
            for (int j = 0; j < arr.length-1-i ; j++) {//控制比较的次数
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }


    public static void bubbleSortDESC(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 -i ; j++) {
                if (arr[j]<arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
