package com.xiongliang.pratice.LeetCode;

import android.util.ArraySet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串，请找出其中不含有重复字符的最长子串的长度
 *
 * 思路：
 * 1： 暴力法， 时间复杂度O(n^3), 空间复杂度O(n)->空间复杂度可以通过从两边往中间遍历判断优化为O(1)
 *
 * 2： 窗口滑动法, Map<String,Integer>, char 和 position+1, start, 当遇到重复时,更新start值为新重复的值,ans 为最长不含重复字符的子串长度,
 *    ans = (i-start) +1
 *   时间复杂度O(n),空间复杂度O(n)
 *
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/hua-jie-suan-fa-3-wu-zhong-fu-zi-fu-de-zui-chang-z/
 */
public class LeetCode4 {
    public static void main(String args[]){
        String str = "1234567890";
//        method1(str);
        method2(str);
    }

    /**
     *  暴力法
     */
    public static void method1(String str){
        int max =0;
        int maxStart = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length() ; j++) {
                 String tmp = str.substring(i,j+1);
                 if(isRepeat(tmp)){
                     if(j+1-i > max){
                         max = j+1-i;
                         maxStart = i;
                     }
                 }
            }
        }

        System.out.println("不含重复的最长字符串长度为="+max+"maxStart="+maxStart+"字符串为="+str.substring(maxStart,maxStart+max));
    }


    /**
     * 窗口滑动法
     */
    public static int method2(String str){
        int ans = 0; //最长不重复字符串大小
        int start = 0;
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
             if(map.containsKey(str.charAt(i))){
                 start = i;
             }

             if((i-start) > ans){
                 ans = i-start +1;
             }

             map.put(str.charAt(i)+"",i+1);

        }

        System.out.println("不含重复的最长字符串长度为="+ans+"字符串为="+str.substring(start,ans));
        return ans;
    }


    /**
     * 判断字符串是否重复
     * @param str
     * @return
     */
    public static boolean isRepeat(String str){
        Set<String> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            if(set.contains(str.charAt(i))){
                return false;
            }
        }

        return true;
    }
}
