package test.demo;

import java.util.Arrays;

/**
 * 快速排序
 *      取一个数为基数（标杆，和其它数对比的数），然后进行比较，比基数大的放在基数左边，比基数小的数放在基数的右边
 *      然后对左右两边的区间  重复上述步骤，直到区间的数为1
 *
 */
public class FaskSort {
    public static void main(String[] args) {
        int[] arr = {11,2,3,4,66,55,44,57,43};
        faskSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void faskSort(int[] arr){
        fasksort(arr,0,arr.length-1);
    }

    private static void fasksort(int[] arr,int low,int high){
        int i,j,index;
        if (low > high)
            return;

        i = low;
        j = high;
        index = arr[i]; //已第一个数为基数
        // 从表的两端 交替 向中间比较
        while (i < j && arr[j] >= index){

            while (i < j && arr[j] >= index)//如果 arr[j] < index,就交换
                j --;
            if (i < j)
                arr[i++] = arr[j]; // 用比基准小的记录替换低位记录
            while (i<j && arr[i] < index)
                i++;
            if (i < j)// 用比基准大的记录 替换高位记录
                arr[j--] = arr[i];
        }

        arr[i] = index;// 将基准数值 替换回 arr[i]

        fasksort(arr,low,i-1);//对低字表进行递归排序
        fasksort(arr,i+1,high);//对高子表进行递归排序

    }

}
