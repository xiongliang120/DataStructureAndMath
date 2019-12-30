package com.xiongliang.pratice.Sort;

/***
 * 希尔排序原理: 插入排序的改进版,会优先比较距离较远的元素。
 * 1) 将数组以间隔N/2 分成2组,对组内同index 元素进行排序
 * 2) 将数组以间隔N/2/2,分成4组,对组内同index元素进行排序,一次递归，直至间隔为0。
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

//    public void insert(int arr[],int gap,int i){
//        int inserted = arr[i];
//        int j;
//        for (j = i -gap; j >=0 && inserted < arr[j];j-=gap){
//            arr[j+gap] = arr[j];
//        }
//        arr[j+gap] = inserted;
//    }

    public void insert(int arr[],int gap,int i){
        int current = arr[i];
        int k = i-gap;
        while(k >= 0){
            if(arr[k] > current){
                int tmp = arr[k];
                arr[k] = arr[k+gap];
                arr[k+gap] = tmp;
            }
            k-=gap;
        }
    }



    public void printArray(int[] sort){
        if(sort != null){
            for (int i=0;i<sort.length;i++){
                System.out.print(sort[i]+".");
            }
        }
    }
}
