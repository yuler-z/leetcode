package sort;

import java.util.Arrays;

/**
 * 快速排序：
 *
 * 重点：
 *     1. partition算法
 *     2. 原址排序，空间O(1)，时间O(logn)
 */
public class QuickSort {


    public static void main(String[] args) {
        int[] arr = new int[]{2,1,1};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort(int[] arr){
       quickSort1(arr, 0, arr.length);
    }
    private static void quickSort1(int[]arr, int begin, int end){
        if(begin >= end - 1){
            return ;
        }

        int pos = partition(arr, begin, end);
        quickSort1(arr, begin, pos);
        quickSort1(arr, pos+1,end);
    }

    /**
     * note: arr[begin, end)
     */
    private static int partition(int[] arr, int begin, int end){
        int pivot = arr[begin];
        while(begin < end){
            while (begin < end && arr[--end] >= pivot);
            arr[begin] = arr[end];
            while (begin < end && arr[++begin] <= pivot);
            arr[end] = arr[begin];
        }
        arr[begin] = pivot;
        return begin;
    }
}
