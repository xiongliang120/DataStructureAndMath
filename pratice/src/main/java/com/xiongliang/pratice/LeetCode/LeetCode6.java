package com.xiongliang.pratice.LeetCode;

/**
 * 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转.
 *  x%10 得到个位数, x/10 去掉个位数
 *
 *  时间复杂度为O(log(x)), x 中大约有log10 (x)位数字
 *  x = 10*n + pop, 第n位
 *  n = 10*(n-1) + pop, 第n-1 位
 *  n = 10*m + pop, 第m位为个位数
 *
 *  x = 10^m + pop*m,  m 大约为log10(x)
 *
 *  空间复杂度为O(1)
 */
public class LeetCode6 {
    public static void main(String args[]) {
        int tmp = -1234567899;
        System.out.println("打印int型数据反转后的值="+reverseInt(tmp));
    }

    public static int reverseInt(int number){
        int result = 0;
        while(number != 0){
            result = result*10+ number%10;
            if(result > Integer.MAX_VALUE){
                result = Integer.MAX_VALUE;
            }

            if(result < Integer.MIN_VALUE){
                result = Integer.MIN_VALUE;
            }

            number = number/10;
        }

        return result;
    }
}
