package com.xiongliang.pratice.LeetCode;

import java.util.PriorityQueue;

/**
 * Type4 是 堆相关
 *
 * 特性:
 * 1) 节点i, 其父节点 parent(i) = (i-1) /2, 其左节点 left(i) = 2*i +1, 其右节点 right(i) = 2*i +2. (i 从0 计数)
 *
 * 数组中第K个最大元素
 * 描述: 在未排序的数组中找到第K个最大的元素。
 */
public class LeetCodeType4_1 {
    public static void main(String args[]){
        int[] array = {3,2,3,1,2,4,5,5,6};
        int k =3;

        //默认小顶堆
        PriorityQueue<Integer> heap = new PriorityQueue<>(k);
        for (int i=0;i<array.length;i++){
            if(heap.size() < k){
                heap.offer(array[i]);
            }else{
                if(array[i] > heap.peek()){
                    heap.poll();
                    heap.offer(array[i]);
                }
            }
        }

        System.out.println("打印第K大数="+heap.peek());
    }
}
