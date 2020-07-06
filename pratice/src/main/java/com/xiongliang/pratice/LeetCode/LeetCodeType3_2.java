package com.xiongliang.pratice.LeetCode;

import com.xiongliang.pratice.BinarySearchTree.BST;

/**
 *  二叉树的中序遍历，前序遍历, 后序遍历
 */
public class LeetCodeType3_2 {
    public static void main(String args[]){
        BST<Integer> bst = new BST<>();
        bst.add(51);
        bst.add(64); bst.add(44);bst.add(29);bst.add(37);
        bst.add(46);bst.add(54);bst.add(33);
        bst.add(78);bst.add(88);bst.add(37);
        bst.add(12);bst.add(80);bst.add(40);
        bst.add(12);

        //中序遍历
        bst.in();

        //前序遍历
        bst.pre();

        //后序遍历
        bst.post();


    }
}
