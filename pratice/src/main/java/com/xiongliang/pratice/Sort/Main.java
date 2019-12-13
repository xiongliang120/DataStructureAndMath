package com.xiongliang.pratice.Sort;


public class Main {
    public static void main(String args[]){
        int[] array = new int[]{2,8,4,10,5,23,9,13};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(array);
        bubbleSort.printArray(array);
//        Integer a = 1;
//        Integer b =1;
//        System.out.println("a ="+a.hashCode()+"b="+b.hashCode());
//
//        String c = "11";
//        String d = "11";
//        System.out.println("c ="+c.hashCode()+"d="+d.hashCode());
    }
}
