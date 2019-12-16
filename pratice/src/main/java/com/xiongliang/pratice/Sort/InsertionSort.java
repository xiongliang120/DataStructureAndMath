package com.xiongliang.pratice.Sort;

/**
 * 插入排序原理: 通过构造有序序列,对于未排序数据, 在已排序序列中从后向前扫描，找到相应位置并插入
 * 1) 遍历集合获取插入元素与已经排好序的所有元素(默认是1个)
 * 2) 如果插入元素大于某个元素则放在元素的右边,   如果小于某个元素则将插入元素与之交换位置,并且交换位置后
 * 的插入元素循环跟左边元素进行对比, 直至大于左边元素或者排序集合遍历结束
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
