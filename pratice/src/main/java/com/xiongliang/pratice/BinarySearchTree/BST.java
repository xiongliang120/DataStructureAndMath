package com.xiongliang.pratice.BinarySearchTree;

/**
 * 二分搜索树
 *
 * @param <E>
 */
public class BST<E extends Comparable<E>> {
    private int size;
    private Node rootNode;

    public class Node {
        private E e;
        private Node left;
        private Node right;

        public Node(E e, Node left, Node right) {
            this.e = e;
            this.left = left;
            this.right = right;
        }
    }

    public BST() {
        rootNode = null;
        size = 0;
    }


    /**
     * 返回元素个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 添加元素
     *
     * @param e
     */
    public void add(E e) {
        if (rootNode == null) {
            rootNode = new Node(e, null, null);
        } else {
            addNode(rootNode, e);
        }
        size++;
    }

    //递归判断元素添加位置
    public void addNode(Node node, E e) {
        if (e.compareTo(node.e) > 0) { // 走右子树
            if (node.right == null) {
                node.right = new Node(e, null, null);
            } else {
                addNode(node.right, e);
            }
        } else if (e.compareTo(node.e) < 0) { //走左子树
            if (node.left == null) {
                node.left = new Node(e, null, null);
            } else {
                addNode(node.left, e);
            }
        }
    }

    /***
     * 移除元素
     * @param e
     */
    public void remove(E e) {
        size--;
    }

    /**
     * 前序遍历
     *
     * @return
     */
    public void pre() {
        System.out.println("\n前序遍历");
        preOrder(rootNode);
    }

    public void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print("value=" + node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 中序遍历
     *
     * @return
     */
    public void in() {
        System.out.println("\n中序遍历");
        inOrder(rootNode);
    }

    public void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print("value=" + node.e);
        inOrder(node.right);
    }

    /**
     * 后序遍历
     *
     * @return
     */
    public void post() {
        System.out.println("\n后序遍历");
        postOrder(rootNode);
    }

    public void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print("value="+node.e);
    }


    public String toString() {
        return "";
    }

}