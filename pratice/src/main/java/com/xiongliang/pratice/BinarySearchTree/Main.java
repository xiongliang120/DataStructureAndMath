package com.xiongliang.pratice.BinarySearchTree;

public class Main {
    public static void main(String args[]){
        BST<Integer> bst = new BST<>();
        for (int i=0;i< 15;i++){
            bst.add(i);
        }

        System.out.println(bst);
    }
}
