package test.arithmetic;

/**
 * 堆排序
 */
public class HeapSortDemo001 {

    public static void main(String[] args) {
        int[] sort=new int[]{1,0,10,20,3,5,6,4,9,8,12,17,34,11};
        buildMaxHeapfy(sort);
        heapSort(sort);
        print(sort);
    }

    public static void buildMaxHeapfy(int[] data){
        //没有子节点的才需要创建最大堆，从最后一个父节点开始
        int startIndex = getParentIndex(data.length-1);
        //从尾端开始创建最大堆，每次都是正确的堆
        for(int i= startIndex; i>=0;i--){
            maxHeapify(data,data.length,i);
        }
    }

    /**
     *创建最大堆
     *
     *@paramdata
     *@paramheapSize需要创建最大堆的大小，一般在sort的时候用到，因为最多值放在末尾，末尾就不再归入最大堆了
     *@paramindex当前需要创建最大堆的位置
     */
    private static void maxHeapify(int[] data, int heapSize,int index){

        //当前点与左右节点比较
        int left = getChildLeftIndex(index);
        int right = getChildRightIndex(index);

        int largest = index;
        if (left < heapSize && data[index] < data[left])
            largest = left;
        if (right<heapSize && data[largest]<data[right])
            largest = right;

        //得到最大值后可能需要交换，如果交换了，其子节点可能不是最大堆了，需要重新调整
        if (largest != index){
            int temp = data[index];
            data[index] = data[largest];
            data[largest] = temp;
            maxHeapify(data,heapSize,largest);
        }
    }


    private static void heapSort(int[] data){
        //末尾与头交换，交换后调整最大堆、
        for (int i = data.length-1; i > 0; i--) {
            int temp = data[0];
            data[0] = data[i];
            data[i] = temp;
            maxHeapify(data,i,0);

        }
    }



    //父节点位置
    private static int getParentIndex(int current){
        return (current-1)>>1;
    }

    /**
     * 左子节点 下标
     * @param current
     * @return
     */
    private static int getChildLeftIndex(int current){
        return (current<<1)+1;
    }

    // 右子节点 下标
    private static int getChildRightIndex(int current){
        return (current<<1)+2;
    }

    private static void print(int[] data){
        int pre = -2;
        for (int i = 0; i < data.length; i++) {
            if(pre < (int)getLog(i+1)){
                pre = (int)getLog(i+1);
            }
            System.out.print(data[i]+"|");
        }
    }

    /**
     * 以 2 为底的对数
     * @param param
     * @return
     */
    private static double getLog(double param){
        return Math.log(param)/Math.log(2);
    }
}
