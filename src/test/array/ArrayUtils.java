package test.array;

/**
 * 数组工具类
 */
public class ArrayUtils{
    public static void printArray(int[] arr){
        System.out.print("{");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length -1)
                System.out.print(", ");
        }
        System.out.println("}");
    }

    public static void exchangeElements(int[] arr,int index1,int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}

