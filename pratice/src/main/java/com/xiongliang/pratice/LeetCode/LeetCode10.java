package com.xiongliang.pratice.LeetCode;

/**
 * 盛最多水的容器
 * 1.暴力法 时间复杂度为O(n^2),空间复杂度O(1).
 *
 * 2.双指针法
 *  面积 = index差 * 最短的高度
 *  从左右index开始,维持最大index差,寻找最短高,不断向中间靠拢, 找出最大的面积
 */
public class LeetCode10 {
    public static void main(String args[]) {
        int[] attr = {5,2,9,6,4};
        System.out.println("打印最大面积="+doubleMethod(attr));

    }

    /***
     * 双指针法
     * @return
     */
    public static int doubleMethod(int attr[]){
        int start =0;
        int end = attr.length -1;
        int max = 0;

        while (start < end){
            if(attr[start] < attr[end]){
                max = Math.max(max,(end-start)* attr[start]);
                start++;
            }else{
                max = Math.max(max,(end-start)* attr[end]);
                end--;
            }
        }

        return max;
    }
}
