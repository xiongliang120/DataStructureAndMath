package com.xiongliang.pratice.LeetCode;

import com.xiongliang.pratice.BinarySearchTree.BST;

/**
 * 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的,递归实现
 *
 * 时间复杂度： 遍历每个元素，因此是O(n)
 * 空间复杂度： 迭代次数为其高度logN, 空间复杂O(logN)
 */
public class LeetCodeType1_3 {
    public static void main(String args[]) {
        BST<Integer> bst = new BST<>();
        bst.add(51);
        bst.add(64); bst.add(44);bst.add(29);bst.add(37);
//        bst.add(46);bst.add(54);bst.add(33);
//        bst.add(78);bst.add(88);bst.add(37);
//        bst.add(12);bst.add(80);bst.add(40);
//        bst.add(12);

        bst.checkTreeSymmetric();
    }
}
