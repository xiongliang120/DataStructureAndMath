package com.xiongliang.pratice.LeetCode;

import java.util.Stack;

/**
 * Type3 是栈相关
 *
 * 有效的括号
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度
 * 例如："(()" 长度为2； ")()())" 长度为4
 *
 *  解题思路：
 *  遇到'(' 将其放入栈顶, 遇到')' 将其移出栈顶, 最后判断栈是否为空，为空，则该字符串是有效括号。
 * 遍历字符串，子遍历每个2个元素遍历, 不断获取字符串去判断是否是有效的,取所有判断的最大值。
 *
 *  时间复杂度：O(n^3),空间复杂度为O(n)
 *
 */
public class LeetCodeType3_1 {
    public static void main(String args[]){
        String str = "(()))()";
        int max = 0;
        for (int i=0;i<str.length();i++){
            for (int k=i+2;k<str.length();k=k+2){ // 括号数必须是偶数
                  String tmp = str.substring(i,k); //包前不包后
                  if(isVaild(tmp)){
                      max = Math.max(max,(k-i)/2);
                  }
            }
        }
        System.out.println("打印最大长度为="+max);
    }

    public static boolean isVaild(String s){
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<s.length();i++){
            if("(".equals(s.charAt(i))){
                stack.push(1);
            }else if(")".equals(s.charAt(i))){
                stack.pop();
            }
        }
        return stack.empty();
    }
}
