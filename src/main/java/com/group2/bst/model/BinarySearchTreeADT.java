package com.group2.bst.model;

public interface BinarySearchTreeADT<E> extends BinaryTreeADT<E> {
    boolean insert(E element);
    boolean removeElement(E element);
    E findMin();
    E findMax();
    boolean contains(E element);
    void rebalance();
}
