package com.xiongliang.pratice.LeetCode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * 前k个高频元素
 *
 * 描述：
 * 给定一个非空的整数数组,返回其中出现频率前k高的元素。
 * 示例:
 *  nums = [1,1,1,2,2,3], k=2
 *  输出 [1,2]
 *
 *  思路:
 *  先通过哈希表维护元素出现频率, 再通过最小堆找出前k高频率的元素
 *  PriorityQueue 优先队列,二叉小顶堆实现,自定义比较器
 *  add() 插入元素
 *  element() 获取队首元素,但不删除元素
 *  remove() 获取队首元素,并删除元素
 *
 */
public class LeetCodeType4_2 {
    public static void main(String args[]){
        int nums[] = {1,1,1,3,2,4,5,4,3,3};
        int k = 2;
        final HashMap<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }


        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });

        for(Integer key:map.keySet()){
            priorityQueue.offer(key);

            if(priorityQueue.size() > k){
                priorityQueue.poll();
            }
        }

        //遍历最终数据
        while (!priorityQueue.isEmpty()){
            System.out.println("打印数据="+ priorityQueue.poll());
        }


    }
}
