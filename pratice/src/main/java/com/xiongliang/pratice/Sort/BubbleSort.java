package com.xiongliang.pratice.Sort;

/**
 * 冒泡排序
 * 1) 比较相邻元素，如果第一个比第二个大,就交换两个
 * 2）对每一对相邻元素做1)操作，这样最后的元素会是最大的数
 * 3) 针对所有元素重复上诉步骤
 */

public class BubbleSort {
    public void sort(int[] sort){
        if (sort != null && sort.length > 0){  //这种写法效率有点低
            for (int i=0;i<sort.length;i++){
                for (int j=i+1;j<sort.length;j++){
                    if(sort[i] > sort[j]){
                        int tmp = sort[j];
                        sort[j] = sort[i];
                        sort[i] = tmp;
                    }
                }
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
