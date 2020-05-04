package com.xiongliang.pratice.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Z 字形变换
 * 将一个给定字符串根据给定的行数,以从上往下，从左往右进行Z 字形排序, 然后进行从左往右的输出。
 * List<StringBuffer>存储每行的字符，int i 表示行号，flag 控制行号反转
 *
 * 时间复杂度O(n),空间复杂度O(n)
 */
public class LeetCode5 {
    public static void main(String args[]) {
        String str = "LEETCODEISHIRING";
        changeMethod(str,3);
    }

    public static String changeMethod(String str, int rowNums) {
        List<StringBuffer> list = new ArrayList<>();
        for (int i = 0; i < rowNums; i++) {
            list.add(new StringBuffer());
        }

        int flag = 1; //控制反转
        int i = 0;  //行号
        for (char tmp : str.toCharArray()) {
            list.get(i).append(tmp);
            if (i == 0 || i == rowNums - 1) { // 反转
                flag = -flag;
            }
            i = i - flag;
        }


        StringBuffer stringBuffer = new StringBuffer();
        for (int j = 0; j < rowNums; j++) {
            stringBuffer.append(list.get(j));
        }

        System.out.println("z形状操作为="+stringBuffer.toString());
        return stringBuffer.toString();
    }
}
