package com.xiongliang.pratice.Sort;


public class Main {
    public static void main(String args[]){
        int[] array = new int[]{2,8,4,10,5,23,9,13,7,45,6};
//        System.out.println("冒泡排序");
//        BubbleSort bubbleSort = new BubbleSort();
//        bubbleSort.sort(array);
//        bubbleSort.printArray(array);

//        System.out.println("选择排序");
//        SelectionSort selectionSort = new SelectionSort();
//        selectionSort.sort(array);
//        selectionSort.printArray(array);

//        System.out.println("插入排序");
//        InsertionSort insertionSort = new InsertionSort();
//        insertionSort.sort(array);
//        insertionSort.printArray(array);

        System.out.println("希尔排序");
        ShellSort shellSort = new ShellSort();
        shellSort.sort(array);
        shellSort.printArray(array);

    }
}
