package com.xiongliang.pratice.Sort;

/**
 * 冒泡排序, 时间复杂度O(n^2)
 * 1) 比较相邻元素，如果第一个比第二个大,就交换两个
 * 2）对每一对相邻元素做1)操作，这样最后的元素会是最大的数
 * 3) 针对所有元素重复上诉步骤
 */

public class BubbleSort {
    public void sort(int[] sort){
        //从大到小,大的数据冒起来
        if (sort != null && sort.length > 0){  //这种写法效率有点低
            for (int i=0;i<sort.length;i++){
                for (int j=0;j<sort.length-1 -i;j++){  //最小/大的数据 放在数组最后一个元素
                    if(sort[j] > sort[j+1]){
                        int tmp = sort[j];
                        sort[j] = sort[j+1];
                        sort[j+1] = tmp;
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
