package com.xiongliang.pratice.AVLTree;

import com.xiongliang.pratice.BinarySearchTree.BST;

/**
 * AVL 树 -- 既是平衡二叉树又是二分搜索树
 * 相比二分搜索树新增概念:  节点高度， 平衡因子(即左右子树高度差)
 * 平衡维护:
 * 1) 某节点的左节点的左节点添加元素导致其平衡性被打破， 采取方式是右旋转
 * 2) 某节点的右节点的右节点添加元素导致其平衡性被打破,  采取方式是左旋转
 *
 * */
public class AVLTree<E extends Comparable<E>> {
    private int size;
    private Node rootNode;

    public class Node {
        private E e;
        private Node left;
        private Node right;
        private int height;  //节点高度

        public Node(E e, Node left, Node right) {
            this.e = e;
            this.left = left;
            this.right = right;
        }
    }

    public AVLTree() {
        rootNode = null;
        size = 0;
    }

    /**
     * 获取节点高度
     * @param node
     */
    public int getHeight(Node node){
        if(node == null){
            return 0;
        }
        return node.height;
    }

    /**
     * 获取节点平衡因子(即左右子树高度差)
     * @param node
     * @return
     */
    public int getBalance(Node node){
       if(node == null){
           return 0;
       }
       return node.left.height - node.right.height;
    }


    /**
     * 右旋转 -- 左斜三个点, 顶点围绕中点右转
     */
    public Node rightRotation(Node node){
        Node secondNode = node.left;

        if(secondNode != null){
            Node tmpNode = secondNode.right;
            node.left = tmpNode;
            secondNode.right = node;
        }
        //更新顶点和中点的height
        node.height = Math.max(node.left.height,node.right.height) +1;
        secondNode.height = Math.max(secondNode.left.height,secondNode.right.height) +1;
        return secondNode;
    }

    /**
     * 左旋转 -- 右斜三个点，顶点围绕中点左转
     * @param node
     * @return
     */
    public Node leftRotation(Node node){
        Node secondNode = node.right;

        if(secondNode != null){
            Node tmpNode = secondNode.left;
            node.right = tmpNode;
            secondNode.left = node;
        }
        //更新顶点和中点的height
        node.height = Math.max(node.left.height,node.right.height) +1;
        secondNode.height = Math.max(secondNode.left.height,secondNode.right.height) +1;
        return secondNode;
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
    public Node addNode(Node node, E e) {
        if (e.compareTo(node.e) > 0) { // 走右子树
            if (node.right == null) {
                Node tmpNode = new Node(e,null,null);
                node.right = tmpNode;
                return node;
            }
            node.right = addNode(node.right, e);


        } else if (e.compareTo(node.e) < 0) { //走左子树
            if (node.left == null) {
                Node tmpNode = new Node(e,null,null);
                node.left = tmpNode;
                return node;
            } else {
                node.left = addNode(node.left, e);
            }
        }

        //更新height
        node.height = Math.max(node.left.height,node.right.height);

        //计算平衡因子
        int balance = Math.abs(node.left.height - node.right.height);

        if(balance <= 1){

        }


        return node;
    }





}
