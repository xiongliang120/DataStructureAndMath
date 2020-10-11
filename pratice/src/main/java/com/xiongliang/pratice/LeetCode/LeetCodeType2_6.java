package com.xiongliang.pratice.LeetCode;

/***
 *  链表反转
 * 示例：1->2->3->4 ,返回4->3->2->1
 *
 * 时间复杂度O(n)
 * 空间复杂度O(1)
 */
public class LeetCodeType2_6 {
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

        ListNode resultNode =  reverseNode(oneNode);

        //打印结果
        while (resultNode !=null){
            System.out.println("node="+resultNode.val);
            resultNode = resultNode.next;
        }

    }


    /**
     * 链表反转
     */
    public  static  ListNode reverseNode(ListNode listNode){
          ListNode currentNode = listNode;
          ListNode preNode = null;
          ListNode nextNode = null;

          while (currentNode != null){
              nextNode = currentNode.next;
              currentNode.next = preNode;
              preNode = currentNode;
              currentNode = nextNode;
          }

          return preNode;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
