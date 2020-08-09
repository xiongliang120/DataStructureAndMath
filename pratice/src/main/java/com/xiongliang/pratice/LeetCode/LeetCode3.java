package com.xiongliang.pratice.LeetCode;


/**
 *  给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *  暴力求解: 时间复杂度O(n^3), 空间复杂度O(1)
 *  列举所有子串，判断是否为回文串，保留最长串
 *
 *
 *   中心扩散算法：时间复杂度O(n^2), 空间复杂度为O(1)
 *   1) 一个元素为中心扩散
 *   2) 2个元素为中心扩散
 *   https://leetcode-cn.com/problems/longest-palindromic-substring/solution/5java-dong-tai-gui-hua-zhong-xin-kuo-zhan-xiang-xi/
 */
public class LeetCode3 {
    public static void main(String args[]){
        String str = "abccbaabccsfd";
        method1(str);
    }


    /***
     * 暴力法 ,循环判断所有字符串是否是回文
     * @param str
     */
    public static void method1(String str){
        int  max = 0;
        String maxStr = "";
        for (int i=0;i<str.length();i++){
            for (int j=i+1;j<str.length();j++){
                String tmp = str.substring(i,j);
                if(isVaild(tmp) && tmp.length() > max){
                    max = tmp.length();
                    maxStr = tmp;
                }
            }
        }

        System.out.println("打印最大回文串大小="+maxStr);
    }

    /**
     * 判断是否是回文串, 对称字符是否一致, 不论奇偶
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


    /**
     * 中心扩散法
     */
    public static void method2(String str){
        int length = str.length();
        int maxLength = 0;
        int start = 0;
        for (int i = 0;i<length;i++){

            //以一个元素为中心,j 是增量
            for (int j=0;i-j>=0&&i+j<length;j++){
                  if(str.charAt(i-j) != str.charAt(i+j)){
                      break;
                  }else{
                      if((2*j+1) > maxLength){
                          maxLength = 2*j+1;
                          start = i-j;
                      }
                  }
            }

            //以两个元素为中心,j 是增量
            for (int j=0; i-j>=0 && i+j+1<length;j++){
                if(str.charAt(i-j) != str.charAt(i+j+1)){
                    break;
                }else{
                    if((2*j+2) > maxLength){
                        maxLength = 2*j+2;
                        start = i-j;
                    }
                }
            }
        }

        String result = str.substring(start,start+maxLength);

        System.out.println("打印最长回文串为="+result);
    }
}
