package test.arithmetic;

import java.util.Arrays;

/**
 */
public class InsertSort {
    //插入排序 ： 工作原理非常类似于我们抓扑克牌
    /*
        1.从第一个元素开始，该元素可以认为已经被排序
        2.取出下一个元素，在已经排序的元素序列中从后向前扫描
        3.如果该元素（已排序）大于新元素，将该元素移到下一位置
        4.重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
        5.将新元素插入到该位置后
        6.重复步骤2~5
     */
    public static void main(String[] args) {
        int[] arr = {6,3,2,4,5,9,7,10,8,12,11};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /*
       6,3,5,9,7,10,8,12,11

       3,6,5,9,7,10,8,12,11


       3,5,7,9,6,10,8,12,11
     */
    public static void insertSort(int[] arr){
        int temp = 0;//用来存放当前比较的数
        int i = 0;//控制比较元素的下标
        int j = 0;//代表已经排序的下标
        for (i= 1; i < arr.length; i++) {//数组第一个默认有序，不需要比较
            temp = arr[i];//这一轮比较的数
            j = i-1;//已经排序的下标   最后一个 是当前比较元素的前一个元素
            while(j>=0 && temp<arr[j]){//从后往前遍历数组
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;//如果
        }
    }

}
