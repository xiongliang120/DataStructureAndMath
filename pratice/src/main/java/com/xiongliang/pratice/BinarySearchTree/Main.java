package com.xiongliang.pratice.BinarySearchTree;

import java.util.Random;

public class Main {
    public static void main(String args[]){
        BST<Integer> bst = new BST<>();

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
        bst.add(51);
        bst.add(64); bst.add(44);bst.add(29);bst.add(37);
        bst.add(46);bst.add(54);bst.add(33);
        bst.add(78);bst.add(88);bst.add(37);
        bst.add(12);bst.add(80);bst.add(40);
        bst.add(12);

        //前序遍历
        bst.pre();
        //中序遍历
        bst.in();
        //后序遍历
        bst.post();
    }
}
