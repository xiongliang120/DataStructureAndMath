package com.xiongliang.pratice.AVLTree;

import com.xiongliang.pratice.BinarySearchTree.BST;

/**
 * AVL 树 -- 既是平衡二叉树又是二分搜索树
 * 相比二分搜索树新增概念:  节点高度， 平衡因子(即左右子树高度差)
 * 平衡维护:
 * 1) 某节点的左节点的左侧添加元素导致其平衡性被打破 LL， 采取方式是右旋转
 * 2) 某节点的右节点的右侧添加元素导致其平衡性被打破 RR,  采取方式是左旋转
 * 3）某节点的左节点的右侧添加元素导致其平衡性被打破 LR， 采取方式是 中点围绕第三点左旋转变为LL, 后面同1）
 * 4）某节点的右节点的左侧添加元素导致其平衡性被打破 RL， 采取方式是 中点围绕第三点右旋转变为RR, 后面同2）
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
            this.height = 1;
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
       return getHeight(node.left) - getHeight(node.right);
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
        node.height = Math.max(getHeight(node.left),getHeight(node.right)) +1;
        secondNode.height = Math.max(getHeight(secondNode.left),getHeight(secondNode.right)) +1;
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
        node.height = Math.max(getHeight(node.left),getHeight(node.right)) +1;
        secondNode.height = Math.max(getHeight(secondNode.left),getHeight(secondNode.right)) +1;
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

//        //更新height ??
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;

        //计算平衡因子
        int balance = getBalance(node);

        if(balance > 1 && getBalance(node.left) > 0){  // LL的情况
             node = rightRotation(node);
        }else if(balance <-1 && getBalance(node.right) < 0){  //RR的情况
             node = leftRotation(node);
        }else if(balance > 1 && getBalance(node.left)<0){   //LR的情况
             Node tmpNode = leftRotation(node.left);
             node.left = tmpNode;
        }else if(balance < -1 && getBalance(node.right) > 0){  //RL 的情况
             Node tmpNode = rightRotation(node.right);
             node.right = tmpNode;
        }
        return node;
    }

    /***
     *  判断二叉树是否是二分搜索树
     *  方式: 中序遍历的结果是否是递增的
     * @return
     */
    public void isBinarySearchTree(){
          in();
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
     * 判断是否是平衡二叉树
     * 方式: 判断每个节点的平衡因子是否大于1
     */
    public boolean balance(){
        return isBalance(rootNode);
    }

    public boolean isBalance(Node node){
        if(node == null){
            return true;
        }

        if(getBalance(node) >1){
            return false;
        }

        return isBalance(node.left) && isBalance(node.right);
    }



}
