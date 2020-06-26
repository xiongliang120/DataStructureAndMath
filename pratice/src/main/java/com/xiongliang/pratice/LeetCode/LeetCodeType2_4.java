package com.xiongliang.pratice.LeetCode;

/***
 * 旋转链表
 * 描述：给定一个链表,将链表每个节点向右移动k个位置,其中k 为非负数
 *
 * 示例：
 * 1->2->3->4->5->NULL, k=2
 * 4->5->1->2->3->NULL.
 *
 * 思路：
 * 将旧链表连接成换,找到新的链表头尾，然后断开环。
 * 新的尾节点为 (n-k) % n
 *
 * 时间复杂度 O(n)
 * 空间复杂度O(1)
 */

public class LeetCodeType2_4 {
    public static void main(String args[]) {
        ListNode oneNode = new ListNode(7);
        ListNode oneNode1 = new ListNode(8);
        ListNode oneNode2 = new ListNode(9);
        ListNode oneNode3 = new ListNode(10);
        ListNode oneNode4 = new ListNode(11);
        ListNode oneNode5 = new ListNode(12);
        ListNode oneNode6 = new ListNode(13);

        oneNode.next = oneNode1;
        oneNode1.next = oneNode2;
        oneNode2.next = oneNode3;
        oneNode3.next = oneNode4;
        oneNode4.next = oneNode5;
        oneNode5.next = oneNode6;

        ListNode resultNode = rotateListNode(oneNode,2);

        //打印结果
        while (resultNode !=null){
            System.out.println("node="+resultNode.val);
            resultNode = resultNode.next;
        }


    }

    /**
     * 旋转链表
     */
    public static ListNode rotateListNode(ListNode headNode,int k){
        if(headNode == null || headNode.next == null){
            return headNode;
        }

        ListNode tailNode = headNode;  //首尾相连
        int n;
        for (n=1; tailNode.next != null; n++){
             tailNode = tailNode.next;
        }
        tailNode.next = headNode;

        ListNode  newtailNode = headNode;  //寻找新尾节点
        ListNode  newheadNode ;   //寻找新的头节点
        for (int i=1; i< (n-k% n -1);i++){
             newtailNode = newtailNode.next;
        }
        newheadNode = newtailNode.next;
        newtailNode.next = null;

        return newheadNode;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
