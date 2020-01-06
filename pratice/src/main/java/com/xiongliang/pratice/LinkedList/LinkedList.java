package com.xiongliang.pratice.LinkedList;

/**
 * 链表
 * 1) 线性结构，每个节点都有指向下个节点的引用
 * 2) 支持增删改查
 *
 *  时间复杂度O(n)
 */
public class LinkedList<E> {
    //链表存储数据个数
    private int size;
    private Node virtual;

    public class Node{
        private E e;
        private Node next;

        public Node(E e,Node node){
            this.e = e;
            this.next = node;
        }

        public String toString(){
            return "node="+ e;
        }
    }

    public LinkedList(){
        virtual = new Node(null,null);
        size = 0;
    }


    /**
     * 添加元素
     * @param index
     * @param e
     */
    public void add(int index,E e){
        if(index < 0 || index > size){
            System.out.println("操作数据越界");
            return;
        }

        Node preNode = virtual;
        for (int i=0;i<index;i++){
            preNode = preNode.next;
        }
        Node tmpNode = preNode.next;
        Node node = new Node(e,tmpNode);
        preNode.next = node;
        size ++;
    }

    /**
     * 移除元素 E
     * @param e
     */
    public void remove(E e){
         int index = find(e);
         remove(index);
    }

    /**
     * 移除index 对应的节点
     * @param index
     */
    public void remove(int index){
        if(index < 0 || index > size){
            System.out.println("操作数据越界");
            return;
        }
        Node preNode = virtual;
        for (int i=0;i<index;i++){
            preNode = preNode.next;
        }
        Node tmpNode = preNode.next.next;
        preNode.next = tmpNode;
        size --;
    }

    /**
     * 更新index 对应节点
     * @param index
     * @param e
     */
    public void set(int index,E e){
        if(index < 0 || index > size){
            System.out.println("操作数据越界");
            return;
        }

        Node preNode = virtual;
        for (int i=0;i<index;i++){
            preNode = preNode.next;
        }
        if(preNode != null){
            preNode.e = e;
        }
    }

    /**
     * 链表是否包含元素
     * @param e
     * @return
     */
    public boolean contains(E e){
        Node preNode = virtual;
        for (int i=0;i<=size;i++){
            preNode = virtual.next;
            if(preNode.e == e){
                return true;
            }
        }
        return false;
    }

    /**
     * 查找元素对应的index
     * @param e
     * @return
     */
    public int find(E e){
        Node preNode = virtual;
        for (int i=0;i<=size;i++){
            preNode = virtual.next;
            if(preNode.e == e){
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("链表容量="+size);
        Node preNode = virtual;
        for (int i=0;i<size;i++){
            preNode = preNode.next;
            sb.append("index="+i+"value="+preNode.e+";");
        }

        return sb.toString();
    }
}
