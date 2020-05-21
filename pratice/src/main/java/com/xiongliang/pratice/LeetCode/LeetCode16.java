package com.xiongliang.pratice.LeetCode;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/***
 * 电话号码的字母组合
 *  给定一个仅包含数字2-9的字符串,返回所有它能表示的字母组合。
 *  1 不对应任何字母。 2对应a/b/c,3对应d/e/f,4对应g/h/i, 等
 *
 *  解题思路：
 *  这是排列组合问题, 可以通过树的形式表示出来。每个数字对应3个分支， 可以转化为从根
 *  节点到空节点右多少路径?
 *
 *
 *  时间复杂度：O(2^ len(s)), len(s)为数字的长度, 时间复杂度如何计算的
 *  空间复杂度：O(len(s))
 *
 *  https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/solution/leetcode-17-letter-combinations-of-a-phone-number-/
 */
public class LeetCode16 {
    public static void main(String args[]) {
        LeetCode16 leetCode16 = new LeetCode16();
        leetCode16.method();

    }

    public  void method() {
        String digit = "23";

        call(digit,0,"");


        for (int i = 0; i < list.size() ; i++) {
            System.out.println("打印list的字符串="+list.get(i));
        }
    }


    private String[] numString = {
            " ",    //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };

    //存储所有可能的字母字符串
    private List<String> list = new ArrayList<>();
    //用于拼接任一种可能的字符串
    private StringBuffer stringBuffer = new StringBuffer();

    /**
     * 递归调用
     * digit:  要匹配的数字字符串
     * index: 字符串的position
     */
    public void call(String digit, int index, String tmpResult) {
        if (index == digit.length()) {
            list.add(tmpResult);
            return;
        }

        int number = digit.toCharArray()[index] - '0';
        char[] charNum = numString[number].toCharArray();
        for (int i = 0; i < charNum.length; i++) {
            call(digit, index + 1, tmpResult+charNum[i]);
        }
    }
}
