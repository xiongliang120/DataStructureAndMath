package com.xiongliang.pratice.ArrayHeap;

import com.xiongliang.pratice.DynamicArray.Array;

/**
 * 最大堆(最小堆) -- 基于动态数组实现完全二叉树，即元素从左到右排列成树的形状(完全二叉树)，并且堆还满足任意节点总是大于
 * 等于其左右子树的节点。
 * 特性:
 * 1) 节点i, 其父节点 parent(i) = (i-1) /2, 其左节点 left(i) = 2*i +1, 其右节点 right(i) = 2*i +2. (i 从0 计数)
 *
 *  添加元素:
 *  1) 在数组最后面添加元素
 *  2）该节点与其父节点做比较做上浮操作，循环做上浮操作直至根节点
 *
 *  取出最大元素(只能取出最大):
 *  1) 取第一个元素，并且使用最后一个元素替代第一个位置
 *  2）第一个元素与其左右子树做比较做下沉操作，循环做下沉操作直至叶子节点
 *
 *  Replace --- 取出最大元素后，放入一个新的元素
 *
 *  heapity --- 将任意数组整理成堆的形状
 * */
public class MaxHeap<E extends Comparable<E>> {
    public Array<E> array;
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
        array.add(e);
    }

    /**
     * 做上浮操作
     */
    public void siftUp(int index){
        try{
            int parentIndex = parentIndex(index);
            if(array.get(index).compareTo(array.get(parentIndex)) > 0){
                E tmpE = array.get(parentIndex);
                array.swap(index,parentIndex);
                siftUp(parentIndex);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }




    /**
     * 删除元素
     * @param e
     */
    public void remove(E e){

    }

    /**
     * index 节点对应的父节点的index
     * @param index
     * @return
     */
    public int parentIndex(int index) throws Exception{
            if(index == 0){
                throw new Exception("index异常");
            }
            return (index-1) /2;
    }

    public int leftIndex(int index){
        return 2*index +1;
    }

    public int rightIndex(int index){
        return 2*index +1;
    }

}
