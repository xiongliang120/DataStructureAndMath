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

//        System.out.println("希尔排序");
//        ShellSort shellSort = new ShellSort();
//        shellSort.sort(array);
//        shellSort.printArray(array);

//        System.out.println("快速排序");
//        QuickSort quickSort = new QuickSort();
//        quickSort.quickSort(array,0,array.length-1);
//        quickSort.printArray(array);

//        System.out.println("堆排序");
//        HeapSort heapSort = new HeapSort();
//        heapSort.sort(array);
////        heapSort.sort2(array);
//        heapSort.printArray(array);

          System.out.println("归并排序");
          MergeSort mergeSort = new MergeSort();
          mergeSort.sort(array);
          mergeSort.printArray(array);
    }
}
