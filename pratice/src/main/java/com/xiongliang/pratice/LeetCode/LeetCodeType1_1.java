package com.xiongliang.pratice.LeetCode;

import com.xiongliang.pratice.BinarySearchTree.BST;

/***
 *  Type1 是广度优先搜索相关, 应用场景: 计算网络跳数； 深度优先搜索算法,其应用场景是: 拓扑排序
 *
 *  二叉树的层序遍历 所有节点， 基于二分搜索树
 *  层序遍历, 采用使用数据结构队列存储,先进先出, 每次从队列中取节点时，相应的将其左右子树添加到队列中。
 *
 *  LinkedBlockingDeque, 链表结构组成的双向堵塞队列
 *  add(), 向队尾添加元素
 *  poll(), 移除队首元素
 *
 */
public class LeetCodeType1_1 {
    public static void main(String args[]) {
        BST<Integer> bst = new BST<>();
        bst.add(51);
        bst.add(64); bst.add(44);bst.add(29);bst.add(37);
        bst.add(46);bst.add(54);bst.add(33);
        bst.add(78);bst.add(88);bst.add(37);
        bst.add(12);bst.add(80);bst.add(40);
        bst.add(12);

        bst.sequence();
    }
}
