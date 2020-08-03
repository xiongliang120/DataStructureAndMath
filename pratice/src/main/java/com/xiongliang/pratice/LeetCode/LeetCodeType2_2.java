package com.xiongliang.pratice.LeetCode;

/***
 * 删除链表的倒数第N个节点
 * 描述: 给定一个链表,删除链表的倒数第n个节点，并且返回链表的头节点
 *
 * 思路：
 * pre 虚拟节点指向头节点
 * 预设前指针start和后指针end, 两者都指向pre头节点, start 先移动n步后，然后start和end 一起移动直到start到链表尾部, 这时
 * end 与start 之间相差n个节点, end的位置刚好在倒数第N个上, 因为刚好要删除这个节点,需要移动到该节点的前一个节点才能删除，
 * 所以循环条件是start.next != null
 *
 * 时间复杂度为 O(n)
 *
 */
public class LeetCodeType2_2 {
    public static void main(String args[]) {
        ListNode oneNode = new ListNode(7);
        ListNode twoNode1 = new ListNode(8);
        ListNode twoNode2 = new ListNode(9);
        ListNode twoNode3 = new ListNode(10);
        ListNode twoNode4 = new ListNode(11);
        ListNode twoNode5 = new ListNode(12);
        ListNode twoNode6 = new ListNode(13);
        ListNode twoNode7 = new ListNode(14);
        ListNode twoNode8 = new ListNode(15);

        oneNode.next = twoNode1;
        twoNode1.next = twoNode2;
        twoNode2.next = twoNode3;
        twoNode3.next = twoNode4;
        twoNode4.next = twoNode5;
        twoNode5.next = twoNode6;
        twoNode6.next = twoNode7;
        twoNode7.next = twoNode8;

        deleteNote(oneNode,3);
    }


    /**
     *
     * @param listNode
     * @param n
     */
    public static void deleteNote(ListNode listNode,int n){
        ListNode pre = new ListNode(0);
        pre.next = listNode;
        ListNode start = pre;
        ListNode end = pre;

        while (n >0){
            start = start.next;
            n--;
        }

        while (start.next != null){
            start = start.next;
            end = end.next;
        }
        end.next = end.next.next;

        printNode(pre.next);
    }

    public static void printNode(ListNode resultNode){
        //打印结果
        while (resultNode !=null){
            System.out.println("node="+resultNode.val);
            resultNode = resultNode.next;
        }
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
}
