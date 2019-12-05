package com.xiongliang.pratice.ArrayHeap;

import com.xiongliang.pratice.DynamicArray.Array;

/**
 * 最大堆(最小堆) -- 基于动态数组实现完全二叉树，即元素从左到右排列成树的形状(完全二叉树)，并且堆还满足任意节点总是大于
 * 等于其左右子树的节点。
 *
 *
 *
 *
 * */
public class MaxHeap<E extends Comparable<E>> {
    private Array<E> array;
    private int size;

    public MaxHeap(){
         array = new Array<>();
         size = 0;
    }

    /**
     * 添加元素
     * @param e
     */
    public void add(E e){

    }

    /**
     * 删除元素
     * @param e
     */
    public void remove(E e){

    }


}
