package com.example.math.LinkedList.LinkedListSet;

public interface Set<E> {

    void add(E e);
    boolean contains(E e);
    void remove(E e);
    int getSize();
    boolean isEmpty();
}
