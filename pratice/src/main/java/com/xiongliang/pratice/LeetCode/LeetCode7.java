package com.xiongliang.pratice.LeetCode;

import java.nio.charset.IllegalCharsetNameException;

/**
 * 字符串转整型
 * 对每个字符进行转换
 *
 */
public class LeetCode7 {
    public static void main(String args[]) {
        String str = "12345678901";
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
            if(result*10+ num > Integer.MAX_VALUE){
                result = Integer.MAX_VALUE;
            }else {
                result = result * 10 + num;
            }
        }

        result = result * flag;

        if(result >Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }

        if(result < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return result;
    }
}
