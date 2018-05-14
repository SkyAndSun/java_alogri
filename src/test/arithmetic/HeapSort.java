package test.arithmetic;

import test.array.ArrayUtils;

/**
 * 堆排序    -----这个有错
 *
 * 步骤
 *      1.构建最大堆
 *      2.选项顶，并与第0位置元素交换
 *      3.由于步骤2的交换可能破坏最大堆的性质，第 0 不再是最大元素，需要
 *          调用maxHeap调整（沉降法），如果需要重复步骤2

 堆排序中最重要的算法就是maxHeap，
    该函数假设一个元素的两个子节点都满足最大堆的性质(左右子树都是最大堆)，只有根元素可能违反最大堆性质，那么把该元素以及左右子节点的最大元素找出来，
    如果该元素已经最大，那么整棵树都是最大堆，程序退出，否则交换跟元素与最大元素的位置，继续调用maxHeap原最大元素所在的子树。该算法是分治法的典型应用。




 堆树的定义如下：

 （1）堆树是一颗完全二叉树；

 （2）堆树中某个节点的值总是不大于或不小于其孩子节点的值；

 （3）堆树中每个节点的子树都是堆树。

 当父节点的键值总是大于或等于任何一个子节点的键值时为最大堆。 当父节点的键值总是小于或等于任何一个子节点的键值时为最小堆。如下图所示，左边为最大堆，右边为最小堆。

 *
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] array = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3 };

        System.out.println("Before heap:");
        ArrayUtils.printArray(array);

        heapSort(array);

        System.out.println("After heap sort:");
        ArrayUtils.printArray(array);
    }

    public static void heapSort(int[] arr){
        if (arr == null || arr.length <= 1)
            return;

        buildMaxHeap(arr);

        for (int i = arr.length -1 ; i >= 1; i--) {
            ArrayUtils.exchangeElements(arr,0,i);

            maxHeap(arr,i,0);
        }
    }

    //建最大堆
    private static void buildMaxHeap(int[] arr){
        if (arr == null || arr.length <= 1)
            return;

        int half = arr.length >> 1;
        for (int i = half; i >=0; i--){
            maxHeap(arr,arr.length,i);
        }
    }

    //最大堆
    private static void maxHeap(int[] arr,int heapSize,int index){
        int left = index << 1 + 1;
        int right = index << 1 + 2;

        int largest = index;

        if (left < heapSize && arr[left] > arr[index]) {
            largest = left;
        }

        if (right < heapSize && arr[right] > arr[largest]){
            largest = right;
        }

        if (index != largest){
            ArrayUtils.exchangeElements(arr,index,largest);

            maxHeap(arr,heapSize,largest);
        }

    }


}
