package com.xiongliang.pratice.LeetCode;

/**
 * 判断一个整数是否是回文数
 * 解法1：
 * 将整数转字符串,循环数组一半的长度进行判断对应元素是否相等。
 *
 * 解法2：
 * 将数字得首位和尾位进行比较，依次进行
 *
 * 时间复杂度O(log10(n)), n 为整数大小
 * 空间复杂度O(1)
 */
public class LeetCode8 {
    public static void main(String args[]) {
         int tmp = 121211;
         System.out.println("打印是否是回文整数="+compareStartAndEnd(tmp));
    }

    public static boolean compareStartAndEnd(int num){
        int div =1; //数字的位数
        while (num /div >= 10){
            div = div * 10;
        }

        while (num >= 10){
            int start = num / div;
            int end = num % 10;
            if(start == end){
                num = (num - start*div)/10;
                div = div/100;
            }else{
                return false;
            }
        }
        return true;
    }

    /**
     * 将整数转字符串, 然后判断是否是回文串, 对称字符是否一致, 不论奇偶
     * @param str
     * @return
     */
    public static boolean isVaild(String str){
        for (int i=0;i<str.length() /2;i++){
            if(str.charAt(i) != str.charAt(str.length() - i -1)){
                return false;
            }
        }
        return true;
    }

}
