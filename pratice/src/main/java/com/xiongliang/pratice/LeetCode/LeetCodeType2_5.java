package com.xiongliang.pratice.LeetCode;

/***
 * 两两交换链表中的节点
 * 给定一个 链表,两两交换其中相邻的节点,并返回交换后的链表(不是单纯的交换值,而是交换节点)
 * 示例：1->2->3->4 ,返回2->1->4->3
 *
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 */
public class LeetCodeType2_5 {
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

        ListNode resultNode =  swapListNode(oneNode);

        //打印结果
        while (resultNode !=null){
            System.out.println("node="+resultNode.val);
            resultNode = resultNode.next;
        }

    }

    /**
     * 链表节点 两两交换
     * @param listNode
     * @return
     */
    public static ListNode swapListNode(ListNode listNode){
        if(listNode == null || listNode.next == null){
            return listNode;
        }
        ListNode pre = new ListNode(0);
        pre.next = listNode;

        ListNode tmpNode = pre;
        while (tmpNode.next != null && tmpNode.next.next != null){
            ListNode start = tmpNode.next;
            ListNode end = tmpNode.next.next;

            tmpNode.next = end;
            start.next = end.next;
            end.next = start;
            tmpNode = start;

        }
        return pre.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
