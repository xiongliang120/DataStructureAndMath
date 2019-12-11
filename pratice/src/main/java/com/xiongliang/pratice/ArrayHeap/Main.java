package com.xiongliang.pratice.ArrayHeap;

public class Main {
    public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        maxHeap.add(5);
        maxHeap.add(15);
        maxHeap.add(2);
        maxHeap.add(8);
        maxHeap.add(7);

        System.out.println(maxHeap.toString());

        maxHeap.remove();
        System.out.println(maxHeap.toString());

    }
}
