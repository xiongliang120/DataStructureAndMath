package com.xiongliang.pratice.AVLTree;


public class main {
    public static void main(String args[]){
        AVLTree<Integer> avlTree = new AVLTree<>();

        /**
         * source=51source=64source=44source=29source=37source=46source=54
         * source=33source=78source=88source=37source=12source=80source=40source=12
         */
        /*
        for (int i=0;i< 15;i++){
            int element = new Random().nextInt(100);
            System.out.print("source="+element);
            bst.add(element);
        }*/
        avlTree.add(51);
        avlTree.add(64); avlTree.add(44); avlTree.add(29); avlTree.add(37);
        avlTree.add(89); avlTree.add(54); avlTree.add(33);
        avlTree.add(78); avlTree.add(88); avlTree.add(37);
        avlTree.add(12); avlTree.add(80); avlTree.add(40);
        avlTree.add(12);



        avlTree.isBinarySearchTree();
        System.out.println("\n是否是平衡二叉树="+avlTree.balance());

    }
}
