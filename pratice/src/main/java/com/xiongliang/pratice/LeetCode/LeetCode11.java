package com.xiongliang.pratice.LeetCode;

import android.os.Build;

/**
 * 整数转罗马数字
 * 罗马数字：
 *  I,V,X,L,C,D,M 分别对应 1,5,10.50,100,500,1000
 *  IV,IX，XL,XC,CD,CM 分别表示4,9,40,90,400,900
 *
 *  题目描述:
 *  给定一个整数,将其转为罗马数字, 输入确保在1到3999的范围内。
 *  思路: 将罗马数字和阿拉伯数字的转换关系用两个数组表示, 然后不断将当前数字与
 *  当前最大单位做比较，每次转换完就减去已转换的数字，再比较直到当前数字等于0。
 *
 *  时间复杂度O(1),虽然看着是双层循环,其实其循环次数是有限制。
 *  空间复杂度O(1)
 */
public class LeetCode11 {
    public static void main(String args[]) {
       System.out.println(traslateMethod(99));
    }


    public static String traslateMethod(int num){
       StringBuffer stringBuffer = new StringBuffer();
       String str[] = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
       int nums[] = {1000,  900,500, 400, 100,90,  50, 40,  10, 9,   5,  4,   1};
       int index =0;
       while(num > 0){
           int count = num/nums[index];
           while(count-- > 0){ //添加cout个最大罗马数字
               stringBuffer.append(str[index]);
           }
           num = num%nums[index]; //获取去掉最大数后的其余部分,直到最后除断为止
           index ++;
       }
       return stringBuffer.toString();
    }

}
