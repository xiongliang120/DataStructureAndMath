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
        return node;
    }

    public void removeElement(E e){
        try{
            System.out.println("\n 删除元素");
            remove(rootNode,e);
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }

    /**
     * 移除元素
     *
     * @param node
     * @param e
     */
    private Node remove(Node node, E e) throws Exception {
        if (node == null) {
            throw new Exception("找不到元素");
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


    public String toString() {
        return "";
    }

}
