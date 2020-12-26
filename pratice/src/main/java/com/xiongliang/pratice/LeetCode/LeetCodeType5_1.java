package com.xiongliang.pratice.LeetCode;

import java.util.ArrayList;
import java.util.Collections;

/**
 *  随机洗牌算法实现
 */
public class LeetCodeType5_1 {
    private static String[] face = {"黑桃", "红桃", "梅花", "方块"};
    private static String[] number = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "J", "Q", "K"};

    public static void main(String args[]) {
        ArrayList list = new ArrayList();

        //默认排序 黑桃(A-K),红桃(A-K),梅花(A-K),方块(A-K)
        for (int i = 0; i < 52; i++) {
            list.add(face[i % 4] + number[i % 13]);
        }

        //对ArrayList 元素进行随机置换
        Collections.shuffle(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
