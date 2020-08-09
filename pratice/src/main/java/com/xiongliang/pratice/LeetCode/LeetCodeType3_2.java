package com.xiongliang.pratice.LeetCode;

import com.xiongliang.pratice.BinarySearchTree.BST;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的中序遍历
 * <p>
 * 方式：
 * 1: 递归处理, 先左,后根,最后右
 * <p>
 * 2：栈
 */
public class LeetCodeType3_2 {
    public static void main(String args[]) {
        BST<Integer> bst = new BST<>();
        bst.add(51);
        bst.add(64);
        bst.add(44);
        bst.add(29);
        bst.add(37);
        bst.add(46);
        bst.add(54);
        bst.add(33);
        bst.add(78);
        bst.add(88);
        bst.add(37);
        bst.add(12);
        bst.add(80);
        bst.add(40);
        bst.add(12);

        //中序遍历
        bst.in();

        orderByStack(bst);
    }

    /**
     * 基于栈的中序遍历
     */
    public static void orderByStack(BST<Integer> root) {
        List<Integer> list = new ArrayList<>();
        BST.Node current = root.getRootNode();
        Stack<BST.Node> stack = new Stack<>();


        //利用栈先进后出的特性
        while (current != null || !stack.isEmpty()) {

            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            list.add((Integer) current.e);
            current = current.right;
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println("中序遍历=" + list.get(i));
        }
    }
}
