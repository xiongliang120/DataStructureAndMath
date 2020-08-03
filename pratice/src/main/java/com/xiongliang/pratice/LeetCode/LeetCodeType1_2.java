package com.xiongliang.pratice.LeetCode;

import com.xiongliang.pratice.BinarySearchTree.BST;

/**
 * 广度优先搜索
 * 二叉树的最小深度
 *
 * 时间复杂度：因为要遍历每一个元素,因此时间复杂度为O(N),N为节点个数
 * 空间复杂度: 每个节点只有一个子树，高度为N,  如果是平衡树,树的高度是log(N). 因此空间复杂度为O(log(N))
 *
 */
public class LeetCodeType1_2 {
    public static void main(String args[]) {
        BST<Integer> bst = new BST<>();
        bst.add(51);
        bst.add(64); bst.add(44);bst.add(29);bst.add(37);
        bst.add(46);bst.add(54);bst.add(33);
        bst.add(78);bst.add(88);bst.add(37);
        bst.add(12);bst.add(80);bst.add(40);
        bst.add(12);

        bst.getTreeSmallDepth();
    }
}
