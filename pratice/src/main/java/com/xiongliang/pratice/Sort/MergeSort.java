package com.xiongliang.pratice.Sort;

/**
 * 归并排序原理:  采用分治法, 将已有序列的子序列合并,得到完全有序的序列,即先使每个序列有序,再使子序列段间有序。
 * 递归实现
 *
 * https://blog.csdn.net/qq_36442947/article/details/81612870
 * https://blog.csdn.net/weixin_39651041/article/details/80010906
 */
public class MergeSort {
    public int[] sort(int arr[]){
       return null;
    }

    public void mergeSort(int arr[],int left, int middle,int right){

    }

    public void printArray(int[] sort){
        if(sort != null){
            for (int i=0;i<sort.length;i++){
                System.out.print(sort[i]+".");
            }
        }
    }
}
