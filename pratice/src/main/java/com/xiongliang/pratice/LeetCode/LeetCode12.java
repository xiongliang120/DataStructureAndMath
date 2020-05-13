package com.xiongliang.pratice.LeetCode;

/**
 * 罗马数字转整数
 * 描述：
 * 给定一个罗马数字,将其转换为整数，输入确保在1到3999范围内
 * 仿照前一题整数转罗马数字
 *
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 */
public class LeetCode12 {
    public static void main(String args[]) {
        System.out.println("打印罗马数字转整数="+traslateMethod("CDXL"));
    }

    public static int traslateMethod(String tmp){
        String str[] = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int nums[] = {1000,  900,500, 400, 100,90,  50, 40,  10, 9,   5,  4,   1};
        int result =0;

        for (int i=0;i<str.length;i++){
            if(tmp.length() >1 && str[i].equals(tmp.substring(0,2))){ //先判断2个字母，然后判断一个字母
                result = result + nums[i];
                tmp = tmp.substring(2);
            }else if(tmp.length() >0 && str[i].equals(tmp.substring(0,1))){
                result = result + nums[i];
                tmp = tmp.substring(1);
            }
        }

        return result;
    }
}
