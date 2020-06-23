package com.xiongliang.pratice.BinarySearchTree;

import android.util.Log;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 二分搜索树
 * 1) 非线性结构, 满足每个节点值大于其左子树所有节点的值，并且小于其右子树所有节点的值
 * 2) 前序遍历， 先遍历根节点，接着遍历左子树，再遍历右子树
 * 3) 中序遍历， 先遍历左子树，接着遍历根节点，最后遍历右子树
 * 4) 后序遍历，先遍历左子树，接着遍历右子树，最后遍历根节点
 * 5) 层序遍历，将根结点的左右子结点分别放入队列, 然后移出第一个,接着将该结点的左右子结点添加到队列中,紧接着移出下一个元素，并将该结点的左右子结点分别加入队列,依次类推。
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
     * 添加元素都是作为叶子节点添加的
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
        if (node == null) {    //1) 求解最基本问题
            return new Node(e, null, null);
        }

        if (e.compareTo(node.e) > 0) { // 走右子树
            node.right = addNode(node.right, e);
        } else if (e.compareTo(node.e) < 0) { //走左子树
            node.left = addNode(node.left, e);
        }
        //由下面写法优化为上面写法
//        if (e.compareTo(node.e) > 0) { // 走右子树
//            if (node.right == null) {
//                Node tmpNode = new Node(e,null,null);
//                node.right = tmpNode;
//                return node;
//            }
//            node.right = addNode(node.right, e);
//
//        } else if (e.compareTo(node.e) < 0) { //走左子树
//            if (node.left == null) {
//                Node tmpNode = new Node(e,null,null);
//                node.left = tmpNode;
//                return node;
//            } else {
//                node.left = addNode(node.left, e);
//            }
//        }
        return node;
    }

    public void removeElement(E e) {
        System.out.println("\n 删除元素");
        remove(rootNode, e);
    }

    /**
     * 移除元素
     * 1）叶子节点删除不用做处理
     * 2）只有左子树/右子树, 使用左/右子树替代。
     * 3）左右子树均不为空, 选择右子树的最小元素替代被删除元素;  或者左子树的最大元素替代。
     *
     * @param node
     * @param e
     */
    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }

        if (e.compareTo(node.e) > 0) { //走右子树
            node.right = remove(node.right, e);
        } else if (e.compareTo(node.e) < 0) { //走左子树
            node.left = remove(node.left, e);
        } else {
            size--;
            if (node.left == null) {  //左子树为空
                return node.right;
            }

            if (node.right == null) { //右子树为空
                return node.left;
            }

            //左右子树均不为空，右子树最小元素替代被删除节点
            Node minNode = removeMin(node.right);
            node.right.right = minNode;
            node.right.left = node.left;
            return node.right;

        }
        return node;
    }

    /**
     * 删除以Node 为根的二分搜索树的最小节点
     * 返回删除节点后新的二分搜索树的根
     *
     * @param node
     * @param
     * @return
     */
    public Node removeMin(Node node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = removeMin(node.left);
        return node;
    }


    /**
     * 查找元素
     *
     * @param e
     * @return
     */
    public Node find(Node node, E e) {
        Node resultNode = null;
        if (e.compareTo(node.e) > 0) {
            if (node.right != null) {
                find(node.right, e);
            }
        } else if (e.compareTo(node.e) < 0) {
            if (node.left != null) {
                find(node.left, e);
            }
        } else {
            resultNode = node;
        }
        return resultNode;
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
        System.out.print("value=" + node.e);
    }


    Queue<Node> queue = new LinkedBlockingDeque<>();

    /***
     * 层序遍历
     */
    public void sequence() {
        System.out.println("\n层序遍历");
        sequenceOrder(rootNode);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print("value=" + node.e);
        }
    }


    public void sequenceOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print("value=" + node.e);

        if (node.left != null) {
            queue.add(node.left);
        }

        if (node.right != null) {
            queue.add(node.right);
        }

        sequenceOrder(queue.poll());
    }


    public int getTreeSmallDepth() {
        int smallDepth = getSmallDepth(rootNode);
        System.out.println("xiongliang" + "打印最小深度=" + smallDepth);
        return smallDepth;
    }

    /***
     * 获取二分搜索树的最小深度， 深度优先搜索 递归
     * @return
     */
    public int getSmallDepth(Node node) {
        int min = Integer.MAX_VALUE;
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            return 1;
        }

        if (node.left != null) {
            min = Math.min(min, getSmallDepth(node.left));
        }

        if (node.right != null) {
            min = Math.min(min, getSmallDepth(node.right));
        }

        return min + 1;

    }


    public boolean checkTreeSymmetric(){
        boolean symmetric = checkTreeSymmetric(rootNode.left,rootNode.right);
        System.out.println("xiongliang 打印二叉树对称="+symmetric);
        return symmetric;
    }

    /**
     * 检查二叉树是否对称，即判断根节点的左右两个个节点a,b值是否相等, 然后递归判断其a左子树等于b的右子树并且a右子树等于b的左子树
     *
     * @return
     */
    public boolean checkTreeSymmetric(Node a, Node b) {
        if (a == null && b == null){
            return true;
        }

        if(a == null || b == null){
            return false;
        }

        return a.e == b.e && checkTreeSymmetric(a.left,b.right) && checkTreeSymmetric(a.right,b.left);
    }

    public String toString() {
        return "";
    }

}
