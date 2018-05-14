package test.arithmetic;

import java.util.Arrays;

/**
 * 最大堆     这个有错
 */
public class HeapSortDemo {

    /**
     * 构建大顶堆
     */
    public static void adjustHeap(int[] arr, int i , int len){
        int temp, j;
        temp = arr[i];
        for (j = 2 * i;  j< len; j *= 2) {//沿关键字较大的孩子节点向下筛选
            if (j < len && arr[j] < arr[j + 1])
                ++j; //j为关键字中较大记录的下标
            if (temp >= arr[j])
                break;
            arr[i] = arr[j];
            i = j;
        }
        arr[i] = temp;
    }

    public static void heapSort(int[] arr){
        int i;
        //构建一个大顶堆
        for (i = arr.length/2 -1; i >=0; i--){
            adjustHeap(arr, i,arr.length - 1);
        }
        //将堆顶记录和当前未经排序子序列的最后一个记录交换
        for (i = arr.length - 1; i >= 0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            adjustHeap(arr,0,i-1);//将arr中i-1个记录重新调整为大顶堆
        }
    }

    public static void main(String[] args) {
        int a[] = { 51, 46, 20, 18, 65, 97, 82, 30, 77, 50 };
        heapSort(a);
        System.out.println(Arrays.toString(a));
    }
}
