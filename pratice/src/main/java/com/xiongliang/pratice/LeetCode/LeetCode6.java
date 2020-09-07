package com.xiongliang.pratice.LeetCode;

/**
 * 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀, 如果不存在公共前缀,返回空字符串"".
 * 所有输入只包含小写字母a_z.
 *
 * 水平扫描法: 从后向前扫描
 * 时间复杂度O为(S),S 为所有字符串中字符数量总和
 * 空间复杂度为O(1)
 */

public class LeetCode6 {
    public static void main(String args[]) {
        String[] tmp = {"aaabbccccddd","aabbcdd","aabbcdd"};
        System.out.println("打印最长公共字符串="+ maxStr(tmp));

    }


    /**
     * 最长公共前缀
     * String.indexOf(string), 返回字符串string 在String 中的起始位置, 如果不存在,则返回-1.
     * @param str
     * @return
     */
    public static String maxStr(String[] str){
        String max = str[0];

        for (int i = 1; i < str.length ; i++) {
            while (str[i].indexOf(max) != 0){
                max = max.substring(0,max.length() -1);
                if(max.isEmpty()){
                    return "";
                }
            }
        }

        return max;
    }
}
