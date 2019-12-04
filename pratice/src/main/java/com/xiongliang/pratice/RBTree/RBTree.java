package com.xiongliang.pratice.RBTree;

/**
 * 红黑树 -- 是二分搜索树
 * 了解: 什么是红黑树,优缺点，内部工作原理?
 *  红黑树是二叉查找树,并且是弱平衡二叉树,满足5点性质
 *  1) 节点非红即黑
 *  2）根节点是黑色的
 *  3）每个叶子节点(NULL 节点)是黑色的
 *  4) 每个红色节点的两个子节点都是黑色的(不能有两连续的红色节点)
 *  5）从任一节点到每个叶子节点的路径包含黑色节点树量是相同的
 *
 *  优缺点:
 *  相对严格平衡的AVL树而言, 红黑树是弱平衡, 红黑树旋转次数少，插入最多旋转2次，删除最多3次旋转。 对于需要大量插入,删除操作的可以选用红黑树
 *
 *  工作原理:
 *
 *  应用场景:
 *  java 中 TreeSet, TreeMap 底层都是红黑树
 *
 * 相比二分搜索树新增概念: 颜色(color)
 * 添加节点：
 * 1) 保持最终根节点是黑色的
 * 2）二节点：添加元素在节点的左边，则元素直接标记为红色; 添加元素在节点的右边，则需要对右斜结构进行左旋转，并且给左边元素标记红色
 * 3）三节点：左倾斜上节点右子树添加元素, 中间节点变红色，左右子节点变黑色 -- 颜色翻转。
 * 4）三节点: 左倾斜下节点左子树添加元素，上节点围绕中间节点右旋转， 中间节点变红色，左右子节点变黑色。
 * 5）三节点：左倾斜下节点右子树添加元素，中间节点围绕下节点左旋转变为4)
 *
 *
 * @param <E>
 */
public class RBTree<E extends Comparable<E>>{
    private int size;
    private Node rootNode;
    private static boolean BLACK = false;
    private static boolean RED = true;

    public class Node {
        private E e;
        private Node left;
        private Node right;
        private boolean color;

        public Node(E e,Node left,Node right) {
            this.e = e;
            this.left = left;
            this.right = right;
            this.color = RED;  //默认是红色
        }
    }

    public RBTree() {
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


    public String toString() {
        return "";
    }
}
