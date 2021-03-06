package com.xiongliang.pratice.AVLTree;

import com.xiongliang.pratice.BinarySearchTree.BST;

import java.util.LinkedList;
import java.util.Queue;

/**
 * AVL 树 -- 既是平衡二叉树又是二分搜索树
 * 相比二分搜索树新增概念:  节点高度(从根节点往叶子节点看)， 平衡因子(即左右子树高度差不超过1)
 * 添加元素:
 *
 * 自平衡维护:
 * 1) 某节点的左节点的左侧添加元素导致其平衡性被打破 LL， 采取方式是右旋转
 * 2) 某节点的右节点的右侧添加元素导致其平衡性被打破 RR,  采取方式是左旋转
 * 3）某节点的左节点的右侧添加元素导致其平衡性被打破 LR， 采取方式是 中点围绕第三点左旋转变为LL, 后面同1）
 * 4）某节点的右节点的左侧添加元素导致其平衡性被打破 RL， 采取方式是 中点围绕第三点右旋转变为RR, 后面同2）
 *
 * 删除元素维护平衡：
 * 1）删除叶子节点, 去掉该节点并且维持自平衡
 * 2）删除节点只有左子树, 去掉左子树第一个节点并维持自平衡
 * 3）删除节点只有右子树，去掉右子树第一个节点并维持自平衡
 * 4）删除节点既有左子树又有右子树, 选择右子树的最小节点替代被删节点，右子树删除最小元素也要维持自平衡, 替换元素后整体也要维持平衡
 */
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
     *
     * @param node
     */
    public int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    /**
     * 获取节点平衡因子(即左右子树高度差)
     *
     * @param node
     * @return
     */
    public int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }


    /**
     * 右旋转 -- 左斜三个点, 顶点围绕中点右转
     */
    public Node rightRotation(Node node) {
        Node secondNode = node.left;

        if (secondNode != null) {
            Node tmpNode = secondNode.right;
            node.left = tmpNode;
            secondNode.right = node;
        }
        //更新顶点和中点的height
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        secondNode.height = Math.max(getHeight(secondNode.left), getHeight(secondNode.right)) + 1;
        return secondNode;
    }

    /**
     * 左旋转 -- 右斜三个点，顶点围绕中点左转
     *
     * @param node
     * @return
     */
    public Node leftRotation(Node node) {
        Node secondNode = node.right;

        if (secondNode != null) {
            Node tmpNode = secondNode.left;
            node.right = tmpNode;
            secondNode.left = node;
        }
        //更新顶点和中点的height
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        secondNode.height = Math.max(getHeight(secondNode.left), getHeight(secondNode.right)) + 1;
        return secondNode;
    }

    /**
     * 添加元素 - 维持平衡
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
        if (node == null) {
            size++;
            return new Node(e, null, null);
        }

        if (e.compareTo(node.e) < 0)
            node.left = addNode(node.left, e);
        else if (e.compareTo(node.e) > 0)
            node.right = addNode(node.right, e);
        else // key.compareTo(node.key) == 0
            node.e = e;

        //        //更新height ??
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;

        //计算平衡因子
        int balance = getBalance(node);

        if (balance > 1 && getBalance(node.left) > 0) {  // LL的情况
            return rightRotation(node);
        } else if (balance < -1 && getBalance(node.right) < 0) {  //RR的情况
            return leftRotation(node);
        } else if (balance > 1 && getBalance(node.left) < 0) {   //LR的情况
            Node tmpNode = leftRotation(node.left);
            node.left = tmpNode;
            return rightRotation(node);
        } else if (balance < -1 && getBalance(node.right) > 0) {  //RL 的情况
            Node tmpNode = rightRotation(node.right);
            node.right = tmpNode;
            return leftRotation(node);
        }
        return node;
    }


    /**
     * 删除元素 - 维持平衡
     * @param e
     */
    public void removeElement(E e){
        System.out.println("\n 删除元素");
        remove(rootNode,e);
    }


    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }

        Node retNode = null;
        if (e.compareTo(node.e) > 0) { //走右子树
            node.right = remove(node.right, e);
            retNode = node;
        } else if (e.compareTo(node.e) < 0) { //走左子树
            node.left = remove(node.left, e);
            retNode = node;
        } else {
            if (node.left == null) {  //左子树为空,只走一个分支
                size--;
                retNode =  node.right;
            }else if (node.right == null) { //右子树为空
                size--;
                retNode =  node.left;
            }else{
                //左右子树均不为空，右子树最小节点先被删除(也需保持平衡)，然后该最小节点替换被删除节点
                Node minNode = minNode(node.right);
                Node tmpNode = remove(node.right,minNode.e);
                minNode.right = tmpNode;
                minNode.left = node.left;
                retNode = minNode;
            }
        }

        if(retNode == null){
            return null;
        }

        /** 更新height,height 可能加1,不变,减1
         *  1) 类似链表树,去掉叶子节点,则height 减1
         *  2) 左树比右树少1，去掉右树叶子节点，则height 加1
         */

        retNode.height = Math.max(getHeight(retNode.left), getHeight(retNode.right)) + 1;

        //计算平衡因子
        int balance = getBalance(retNode);

        if (balance > 1 && getBalance(retNode.left) > 0) {  // LL的情况
            return rightRotation(retNode);
        } else if (balance < -1 && getBalance(retNode.right) < 0) {  //RR的情况
            return leftRotation(retNode);
        } else if (balance > 1 && getBalance(retNode.left) < 0) {   //LR的情况
            Node tmpNode = leftRotation(retNode.left);
            retNode.left = tmpNode;
            return rightRotation(retNode);
        } else if (balance < -1 && getBalance(retNode.right) > 0) {  //RL 的情况
            Node tmpNode = rightRotation(retNode.right);
            retNode.right = tmpNode;
            return leftRotation(retNode);
        }

        return retNode;
    }

    /**
     * 查找Node 子树的最小节点
     * @param node
     * @return
     */
    public Node minNode(Node node){
         if(node.left == null){
             return node;
         }
         return minNode(node.left);
    }

    /**
     * 删除以Node 为根的二分搜索树的最小节点
     *  返回删除节点后新的二分搜索树的根
     * @param node
     * @param
     * @return
     */
    public Node removeMin(Node node) {
        if(node.left == null){
            return node.right;
        }
        node.left = removeMin(node.left);
        return node;
    }





    /***
     *  判断二叉树是否是二分搜索树
     *  方式: 中序遍历的结果是否是递增的
     * @return
     */
    public void isBinarySearchTree() {
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
     * 二分搜索树层序遍历
     */
    public void levelOrder(){
        System.out.println("\n 二分搜索树层序遍历");
        Queue<Node> q = new LinkedList<>();
        q.add(rootNode);
        while(!q.isEmpty()){
            Node cur = q.remove();
            System.out.print(cur.e+",");

            if(cur.left != null)
                q.add(cur.left);
            if(cur.right != null)
                q.add(cur.right);
        }
    }

    /**
     * 判断是否是平衡二叉树
     * 方式: 判断每个节点的平衡因子是否大于1
     */
    public boolean balance() {
        return isBalance(rootNode);
    }

    public boolean isBalance(Node node) {
        if (node == null) {
            return true;
        }

        if (getBalance(node) > 1) {
            return false;
        }

        return isBalance(node.left) && isBalance(node.right);
    }


}
