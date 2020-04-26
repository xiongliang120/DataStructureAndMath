package com.xiongliang.pratice.LeetCode;


/**
 *  给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *  暴力求解:
 *  列举所有子串，判断是否为回文串，保留最长串
 */
public class LeetCode3 {
    public static void main(String args[]){
        String str = "abccbaabccsfd";
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
     * 判断是否是回文串
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
