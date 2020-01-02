package com.xiongliang.pratice.Sort;

/**
 * 快速排序原理: 时间复杂度O(nLog2 N)
 * 1) 选最左边元素为基准,先从右往左走找到小于基准的元素a，然后从左往右走找到大于基准的元素b，然后交换元素a,b
 * 2) 循环1）的操作,直至二者在元素c相遇, 则将c 和基准交换
 * 3) 分别对基准元素的左和右子序列执行上诉1)2)操作
 *
 * https://blog.csdn.net/shujuelin/article/details/82423852
 */
public class QuickSort {
    public void quickSort(int arr[], int left, int right){
        if(left > right)
            return;
         int low = left;
         int height = right;
         int temp = arr[left];
         while(low < height){
             //右边先走,找比基准小的数
             while(arr[height] >= temp && low < height){
                 height--;
             }

             //左边走，找比基准大的树
             while(arr[low] <= temp && low < height){
                 low++;
             }

             //左右找到的数进行交换
             if(low < height){
                 int t = arr[low];
                 arr[low] = arr[height];
                 arr[height] = t;
             }
         }
        //low 和 height相遇,则交换基准
        arr[left] = arr[low];
        arr[low] = temp;

        quickSort(arr,left,low-1);
        quickSort(arr,low+1,right);
    }

    public void printArray(int[] sort){
        if(sort != null){
            for (int i=0;i<sort.length;i++){
                System.out.print(sort[i]+".");
            }
        }
    }
}
