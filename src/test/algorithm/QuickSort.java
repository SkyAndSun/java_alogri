package test.algorithm;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {

    public void sort(int[] arr, int low, int high){
        int l = low;
        int h = high;
        int povit = arr[low]; //基准

        while (l<h){
            //当右边比基准要小 时，退出循环
            while(l<h && arr[h]>= povit)
                h --;
            // 判断是否可以交换
            if (l<h){
                // 把 高位的数 交换到 基准数的位置上,此时基准数在 低位上
                int temp = arr[h];
                arr[h] = arr[l];
                arr[l] = temp;
                // 此时 基准数已经到 高位上， 继续从低位开始比较
                l ++;
            }

            //当左边比基准要大时， 退出循环
            while(l<h && arr[l]<=povit)
                l ++;
            if(l<h){
                // 把 低位数 交换到 基准数的位置上  此时 基准数在 高位上
                int temp = arr[h];
                arr[h] = arr[l];
                arr[l] = temp;

                // 此时 基准数 交换到低位  继续从高位开始往左比较
                h --;
            }
        }

        if (l>low)
            sort(arr, low, l-1);
        if (h<high)
            sort(arr,l+1,high);
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] arr = {12,4,6,25,34,21,66,17};
        quickSort.sort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
