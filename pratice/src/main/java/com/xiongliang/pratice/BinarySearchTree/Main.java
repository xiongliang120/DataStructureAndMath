package com.xiongliang.pratice.BinarySearchTree;

public class Main {
    public static void main(String args[]){
        BST<Integer> bst = new BST<>();
        for (int i=0;i< 15;i++){
            bst.add(i);
        }
        //前序遍历
        bst.pre();
    }
}
