package com.xiongliang.pratice.DynamicArray;

/**
 * 动态数组
 * @param <E>
 */
public class Array<E> {
    //数组的容量
    private int arrayLength = 10;
    private E array[] = (E[]) new Object[arrayLength];
    //数组存储元素个数
    private int size = 0;

    /**
     * 获取数组容量
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 向数组添加元素
     *
     * @param e
     */
    public void add(E e) {
        if(size >= arrayLength){
            resize(arrayLength *2);
        }
        array[size] = e;
        size++;
    }

    /**
     * 从数组移除元素 E
     *
     * @param e
     */
    public void remove(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    /**
     * 从数组移除index的元素
     *
     * @param index
     */
    public void remove(int index) {
        array[index] = null;
        for (int i = index + 1; i < size; i++) {
            array[i - 1] = array[i];
        }
        size--;
        if(size <= arrayLength/2){
            resize(arrayLength/2);
        }
    }

    /**
     * 从数组中移除第一个元素
     */
    public void removeFirst() {
         remove(0);
    }

    /**
     * 从数组中移除最后一个元素
     */
    public void removeLast() {
        remove(size-1);
    }

    /**
     * 查找元素对应的index
     *
     * @param e
     * @return
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (array[i] == e) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 数组扩容/缩容
     */
    public void resize(int newSize) {
            E tmpArray[] = (E[]) new Object[arrayLength * 2];
            for (int i = 0; i < size; i++) {
                tmpArray[i] = array[i];
            }
            array = tmpArray;
            arrayLength = newSize;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("数组容量="+arrayLength);
        for (int i = 0; i < size; i++) {
            sb.append("index=" + i + ",value=" + array[i]+";");
        }
        return sb.toString();
    }

}
