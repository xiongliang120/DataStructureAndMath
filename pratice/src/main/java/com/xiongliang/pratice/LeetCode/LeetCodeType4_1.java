package com.xiongliang.pratice.LeetCode;

import java.util.PriorityQueue;

/**
 * Type4 是 堆相关
 * PriorityQueue(优先队列) 通过二叉小顶堆实现。保证每次取出的元素都是队列中权值最小的。
 * add(),offer() 均是向优先队列中插入元素。 满的队列,add会抛出异常, offer 会返回false
 * element(),peek() 均是获取队首元素(最小)但不删除。
 * remove(), poll() 均是获取并删除队首元素。
 * <p>
 * 数组中第K个最大元素
 * 描述: 在未排序的数组中找到第K个最大的元素。
 * <p>
 * 时间复杂度：O(n)
 * 空间复杂度：O(k)
 */
public class LeetCodeType4_1 {
    public static void main(String args[]) {
        int[] array = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 3;

        //默认小顶堆
        PriorityQueue<Integer> heap = new PriorityQueue<>(k);
        for (int i = 0; i < array.length; i++) {
            heap.add(array[i]);
            if(heap.size() > k){
                heap.poll();
            }

//            if (heap.size() < k) {
//                heap.add(array[i]);
//            } else {
//                if (array[i] > heap.peek()) {
//                    heap.poll();
//                    heap.offer(array[i]);
//                }
//            }
        }

        System.out.println("打印第K大数=" + heap.peek());
    }
}
