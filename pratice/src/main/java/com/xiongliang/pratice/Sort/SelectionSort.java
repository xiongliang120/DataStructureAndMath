package com.xiongliang.pratice.Sort;

/**
 *  选择排序原理: 首先在未排序序列中找到最大元素, 存放到已排序序列的末尾位置,循环此操作。
 *
 */
public class SelectionSort {
    public void sort(int[] sort){
        int maxIndex = 0;
        int maxSize =0;
        for (int k =0;k<sort.length;k++){
            for (int i=maxSize;i<sort.length;i++){ //寻找最大index
                if(sort[maxIndex] < sort[i]){
                    maxIndex = i;
                }
            }

            //交换最后元素跟最大元素
            int tmp = sort[maxIndex];
            sort[maxIndex] = sort[maxSize];
            sort[maxSize] = tmp;
            maxSize++;
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
