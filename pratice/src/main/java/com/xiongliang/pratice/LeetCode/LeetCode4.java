package com.xiongliang.pratice.LeetCode;

import android.util.ArraySet;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请找出其中不含有重复字符的最长子串的长度
 *
 * 思路：
 * 1： 暴力法
 * 2： 窗口滑动法
 */
public class LeetCode4 {
    public static void main(String args[]){
        String str = "1234567890";
        method1(str);
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
