package com.xiongliang.pratice.BinarySearchTree;

/**
 *
 * @param <E>
 */
public class BST<E extends Comparable<E>> {
    private int size;
    private Node rootNode;
    public class Node{
        private E e;
        private Node left;
        private Node right;

        public Node(E e,Node left,Node right){
            this.e = e;
            this.left = left;
            this.right = right;
        }
    }

    public BST(){
        rootNode = null;
        size = 0;
    }


    /**
     * 返回元素个数
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 添加元素
     * @param e
     */
    public void add(E e){
        if(rootNode == null){
            rootNode = new Node(e,null,null);
        }else{
            addNode(rootNode,e);
        }
        size++;
    }

    //递归判断元素添加位置
    public void addNode(Node node, E e){
        if(node == null){
            node = new Node(e,null,null);
        }
        if(e.compareTo(node.e) >0){ // 走右子树
             addNode(node.right,e);
        }else if(e.compareTo(node.e) <0){ //走左子树
             addNode(node.left,e);
        }
    }

    /***
     * 移除元素
     * @param e
     */
    public void remove(E e){
        size--;
    }

    /**
     * 前序遍历
     * @return
     */
    public String preOrder() {
        return "";
    }

    /**
     * 中序遍历
     * @return
     */
    public String inOrder(){
        return "";
    }

    /**
     * 后序遍历
     * @return
     */
    public String postOrder(){
        return "";
    }



    public String toString(){
        return "";
    }

}
