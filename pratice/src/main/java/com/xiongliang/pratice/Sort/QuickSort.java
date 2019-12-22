package com.xiongliang.pratice.Sort;

/**
 * 快速排序原理:
 * 1)
 * 2）所有比基准小的放在基准前面，比基准大的放在基准后面，相同的元素可以放任意一边
 * 3）递归把基准左边和右边的序列排序
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
