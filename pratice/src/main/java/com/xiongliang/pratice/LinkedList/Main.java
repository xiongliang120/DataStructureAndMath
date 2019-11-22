package com.xiongliang.pratice.LinkedList;

public class Main {
    public static void main(String args[]){
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i=0;i<11;i++){
            linkedList.add(i,i);
        }

        System.out.println(linkedList);

        linkedList.remove(17);
        System.out.println(linkedList);

        linkedList.set(9,100);
        System.out.println(linkedList);
    }
}
