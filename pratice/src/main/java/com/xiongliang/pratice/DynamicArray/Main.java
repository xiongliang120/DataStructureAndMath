package com.xiongliang.pratice.DynamicArray;

public class Main {
    public static void main(String args[]){
        Array<Integer> array = new Array<>();
        for (int i=0;i< 6;i++){
            array.add(i);
        }

        System.out.println(array.toString());

        array.remove(6);
        System.out.println(array.toString());

    }
}
