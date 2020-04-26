package com.xiongliang.pratice.LeetCode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和.
 * 例如
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 *  解题思路：链表尾部开始对应的每个元素相加,判断进位
 *
 */
public class LeetCode2 {
    public static void main(String args[]){
        ListNode oneNode = new ListNode(7);
        oneNode.next = new ListNode(8);
        oneNode.next.next = new ListNode(9);

        ListNode twoNode = new ListNode(1);
        twoNode.next = new ListNode(2);
        twoNode.next.next = new ListNode(3);

        ListNode  resultNode =addNode(oneNode,twoNode).next;

        //打印结果
        while (resultNode !=null){
            System.out.println("node="+resultNode.val);
            resultNode = resultNode.next;
        }
    }

    /**
     * 两个ListNode 相加
     * @param oneNode
     * @param twoNode
     * @return
     */
    public static ListNode addNode(ListNode oneNode, ListNode twoNode){
          int addNum = 0;

          ListNode resultNode = new ListNode(0);
          ListNode currentNode = resultNode;


          while(oneNode != null && twoNode != null){
               int oneNum = oneNode.val;
               int twoNum = twoNode.val;
               int numResult = oneNum +twoNum;

               //进位添加
               if(addNum >0){
                   numResult ++;
                   addNum = 0;
               }

               //进位判断
               if(numResult > 9){
                   addNum = 1;
                   numResult = numResult % 10;
               }

               currentNode.next = new ListNode(numResult);
               currentNode = currentNode.next;

               oneNode = oneNode.next;
               twoNode = twoNode.next;
          }

          if(addNum > 0){
              currentNode.next = new ListNode(addNum);
          }

          return resultNode;
    }

    static class ListNode{
        public int val;
        public ListNode  next;

        public ListNode(int x){
            this.val = x;
            this.next = null;
        }
    }
}
