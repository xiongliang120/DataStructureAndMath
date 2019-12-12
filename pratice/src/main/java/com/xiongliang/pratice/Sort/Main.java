package com.xiongliang.pratice.Sort;


public class Main {
    public static void main(String args[]){
        int[] array = new int[]{2,8,4,10,5,23,9,13};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(array);
        bubbleSort.printArray(array);
    }
}
