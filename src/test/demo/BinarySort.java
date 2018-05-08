package test.demo;

import java.util.Arrays;

/**
 * 二分查找
 * 前提： 数组是有序的
 *
 * 思想：
 * 有序的序列，每次都是以序列的中间位置的数来与待查找的关键字进行比较，每次缩小一半的查找范围，直到匹配成功。
 *
 * 优缺点：
 *      优点是比较次数少，查找速度快，平均性能好；
 *      其缺点是要求待查表为有序表，且插入删除困难。
 *      因此，折半查找方法适用于不经常变动而查找频繁的有序列表。
 *
 */
public class BinarySort {
    public static void main(String[] args) {

        int[] arr = {33, 22, 34, 1, 2, 3, 4, 66, 44, 11};
        //必须是有序数组
        Arrays.sort(arr);
       /*
        length  10  5   2
        start   0   0   0
        end     10  5   2
        mid     5   2   1
        */
        System.out.println(Arrays.toString(arr));
        int num = 666;  //分别使用 -11  1  11  22  66 666 测试

        int index = binarySortFor(arr, num);
        System.out.println(index);
        index = binarySortRecursion(arr, num);
        System.out.println(index);
    }

    /*
      循环方式
     */
    public static int binarySortFor(int[] arr, int num) {

        int start = 0;
        int last = arr.length - 1;
        int mid = (last + start) >> 1;
        int index = -1;

        //数组是有序的，升序
        if (num < arr[start] || num > arr[last])
            return -1;

        while (start <= last) {
            if (arr[mid] == num) {
                index = mid;
                break;
            }
            // arr[mid] > num 说明，需要查找的数是在左边
            if (arr[mid] > num) {
                last = mid;
                mid = (last + start) >> 1;
            } else {
                start = mid + 1;
                mid = (last + start) >> 1;
            }
        }
        return index;
    }


    public static int binarySortRecursion(int[] arr, int num) {
        //数组是有序的
        if (num < arr[0] || num > arr[arr.length - 1])
            return -1;
        else
            return binarySort(arr, 0, arr.length - 1, num);
    }

    private static int binarySort(int[] arr, int start, int last, int num) {
        int mid = (last + start) >> 1;

        if (start <= last) {
            if (arr[mid] == num) {
                return mid;

            } else if (arr[mid] > num) { // arr[mid] > num 说明，需要查找的数是在左边
                last = mid;
                return binarySort(arr, start, last, num);
            } else {
                start = mid + 1;
                return binarySort(arr, start, last, num);
            }
        } else {
            return -1;
        }
    }


}
