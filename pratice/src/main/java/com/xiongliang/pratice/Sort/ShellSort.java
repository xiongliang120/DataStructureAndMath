package com.xiongliang.pratice.Sort;

/***
 * 希尔排序原理: 插入排序的改进版,会优先比较距离较远的元素。
 *
 *
 * https://blog.csdn.net/qq_39207948/article/details/80006224
 */
public class ShellSort {
    public void sort(int[] arr){
        int N = arr.length;
        for (int gap = N/2;gap>0;gap /= 2){
            for(int i = gap;i <N;i++){
                insert(arr,gap,i);
            }
        }
    }

    public void insert(int arr[],int gap,int i){
        int inserted = arr[i];
        int j;
        for (j = i -gap; j >=0 && inserted < arr[j];j-=gap){
            arr[j+gap] = arr[j];
        }
        arr[j+gap] = inserted;
    }

    public void printArray(int[] sort){
        if(sort != null){
            for (int i=0;i<sort.length;i++){
                System.out.print(sort[i]+".");
            }
        }
    }
}
