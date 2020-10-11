package com.xiongliang.pratice.LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 实现可以获取最小值的栈
 *
 * 思路:  增加辅助栈, 辅助栈里面每次存放的最小值
 *
 * 时间复杂度 O(1), 空间复杂度O(n)
 *
 * https://blog.csdn.net/dingjianmin/article/details/82902193
 *
 */
public class LeetCode8 {
    public static void main(String args[]) {

    }

    List<Integer> data = new ArrayList<>();
    List<Integer> min = new ArrayList<>();

    class CustomeStack {
      public void pop(){
      }

      public void push(int num){
          data.add(num);

          if(min.size() ==0){
              min.add(num);
          }else{
              int minNum = min.get(min.size() -1);
              if(num < minNum){
                  min.add(num);
              }
          }
      }

      public int getMin(){
          if(min.size()==0){
              return -1;
          }
          return min.get(min.size() -1);
      }

    }
}
