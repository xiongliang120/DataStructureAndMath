package com.xiongliang.pratice.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 最接近的三数之和
 * 给定包括n个整数的数组nums 和一个目标值target, 找出nums 中的三个整数，使得它们的
 * 和与target 最接近。
 *
 *  双指针方法
 *  1: 先对数组进行排序
 *  2：从左右开始往中间紧逼
 *
 *  时间复杂度： O(nLogN) + O(n^2) = O(n^2)
 *  空间复杂度：O(1)
 *
 */

public class LeetCode15 {
    public static void main(String args[]) {
        int[] nums= {1,4,2,-1,0,-3};
        sameMethod(nums,-4);
    }

    public static int sameMethod(int[] nums,int target){
        Arrays.sort(nums); //默认升序排序
        int ans = nums[0] + nums[1] +nums[2];

        int tmpHead =0,tmpTail=2,tmpi=1;

        for (int i = 0; i < nums.length; i++) {
            int head = i+1;
            int tail = nums.length -1;

            while (head < tail){
                int sum = nums[i] + nums[head] + nums[tail];

                if(Math.abs(sum -target) < Math.abs(ans - target)){
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
                    return target;
                }
            }
        }

        System.out.println("打印最接近的三数之和="+ans+"..."+nums[tmpHead]+".."+ nums[tmpTail]+"..."+nums[tmpi]);
        return ans;

    }
}
