package com.xiongliang.pratice.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 最接近的三数之和
 * 给定包括n个整数的数组nums 和一个目标值target, 找出nums 中的三个整数，使得它们的
 * 和与target 最接近。
 */

public class LeetCode15 {
    public static void main(String args[]) {
        int[] nums= {1,4,2,-1,0,-3};
        sameMethod(nums,-4);
    }

    public static void sameMethod(int[] nums,int target){
        Arrays.sort(nums); //默认升序排序
        List<List<Integer>> list = new ArrayList<>();
        int ans = nums[0] + nums[1] +nums[2];

        int tmpHead =0,tmpTail=0,tmpi=0;

        for (int i = 0; i < nums.length; i++) {
            int head = i+1;
            int tail = nums.length -1;



            while (head < tail){
                int sum = nums[i] + nums[head] + nums[tail];

                if(Math.abs(target - ans) > Math.abs(sum - target)){
                    ans = sum;
                    tmpHead = head;
                    tmpTail = tail;
                    tmpi = i;
                }


                if(sum < target){
                    head++;
                }else if(sum > target){
                    tail--;
                }else{
                    System.out.println("打印最接近的三数之和="+ans+"..."+nums[tmpHead]+".."+ nums[tmpTail]+"..."+nums[tmpi]);
                    return;
                }

            }


        }

        System.out.println("打印最接近的三数之和="+ans+"..."+nums[tmpHead]+".."+ nums[tmpTail]+"..."+nums[tmpi]);

    }
}
