package com.xiongliang.pratice.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * 给你一个包含n个整数的数组nums, 判断nums中是否存在三个元素a,b,c, 使得a+b+c =0, 找出所有满足条件且不重复的三元组
 *
 * 双指针方法
 * 1: 先对数组进行排序
 * 2：从左右开始往中间紧逼
 *
 * 时间复杂度:
 *  数组排序复杂度 O(nLogN) + O(n^2) = O(n^2)
 *
 *
 */
public class LeetCode14 {
    public static void main(String args[]) {
        int[] nums= {1,4,2,-1,0,-3};
        addMethod(nums);
    }

    public static void addMethod(int[] nums){
        Arrays.sort(nums); //默认升序排序
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
             int head = i+1;
             int tail = nums.length -1;

             while (head < tail){
                 int sum = -(nums[tail] + nums[head]);
                 if(sum == nums[i]){
                     ArrayList arrayList = new ArrayList();
                     arrayList.add(head);
                     arrayList.add(i);
                     arrayList.add(tail);
                     list.add(arrayList);
                     System.out.println("打印三元数组="+nums[head]+"."+nums[i]+"."+nums[tail]);
                 }

                 if(sum <= nums[i]){
                     tail--;
                 }else{
                     head++;
                 }

             }
        }

    }
}
