package com.xiongliang.pratice.Sort;

/**
 * 插入排序原理: 通过构造有序序列,对于未排序数据, 在已排序序列中从后向前扫描，找到相应位置并插入
 *
 *
 */

public class InsertionSort {

    public void sort(int[] sort){
        int preIndex = 0;  //前一个元素
        int currentIndex = 1; //当前元素

        for(int i=currentIndex;i< sort.length;i++){
            preIndex = i-1;
            while (preIndex >= 0 && sort[preIndex] > sort[preIndex+1]){
                int tmp = sort[preIndex];
                sort[preIndex] = sort[preIndex+1];
                sort[preIndex+1] = tmp;
                preIndex--;
            }
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
