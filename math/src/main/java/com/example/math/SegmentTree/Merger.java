package com.example.math.SegmentTree;

public interface Merger<E> {
    E merge(E a, E b);
}
