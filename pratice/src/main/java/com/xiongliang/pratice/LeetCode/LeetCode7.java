package com.xiongliang.pratice.LeetCode;

import java.nio.charset.IllegalCharsetNameException;

/**
 * 字符串转整型
 * 对每个字符进行转换
 *
 * 时间复杂度O(n), n为字符串长度
 * 空间复杂度O(1)
 *
 */
public class LeetCode7 {
    public static void main(String args[]) {
        String str = "1234567891";
        System.out.println("打印整型="+transformationMethod(str));
    }

    public static int transformationMethod(String str){
        int result = 0;
        int flag = 1;  //正负判断, flag =1 为正, flag =-1 为负
        if(str.contains("-")){
            flag = -1;
        }

        for (int i = 0; i < str.length() ; i++) {
            int num = str.charAt(i)- '0';

            if(result > (Integer.MAX_VALUE - num) /10){ //防止result*10 + num 越界
                result = Integer.MAX_VALUE;
            }else if(result < (Integer.MIN_VALUE + num)/10){
                result = Integer.MIN_VALUE;
            }else {
                result = result * 10 * flag + num * flag;
            }
        }


        return result;
    }
}
