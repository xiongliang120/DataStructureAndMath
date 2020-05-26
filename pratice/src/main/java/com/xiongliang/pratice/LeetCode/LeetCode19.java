package com.xiongliang.pratice.LeetCode;

/***
 *  合并两个有序链表
 *  描述：将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class LeetCode19 {
    public static void main(String args[]) {
        ListNode oneNode = new ListNode(7);
        ListNode oneNode1 = new ListNode(8);
        ListNode oneNode2 = new ListNode(9);
        ListNode oneNode3 = new ListNode(10);

        ListNode twoNode = new ListNode(11);
        ListNode twoNode1 = new ListNode(12);
        ListNode twoNode2 = new ListNode(13);
        ListNode twoNode3 = new ListNode(14);

        oneNode.next = oneNode1;
        oneNode1.next = oneNode2;
        oneNode2.next = oneNode3;


        twoNode.next = twoNode1;
        twoNode1.next = twoNode2;
        twoNode2.next = twoNode3;
        addNode(oneNode,twoNode);

    }

    public static void addNode(ListNode oneNode,ListNode twoNode){

    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
