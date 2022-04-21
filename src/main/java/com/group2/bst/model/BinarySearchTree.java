package com.group2.bst.model;

public class BinarySearchTree<E> extends BinaryTree<E> implements BinarySearchTreeADT<E>{

    private BinarySearchTreeNode<E> root;

    public BinarySearchTree() {
        super(null, 0);
        this.root = null;
    }

    public BinarySearchTree(BinaryTreeNode<E> root, int size) {
        super(root, size);
        this.root = null;
    }

    @Override public boolean insert(E element) {
        return false;
    }

    @Override public boolean removeElement(E element) {
        return false;
    }

    @Override public E findMin() {
        return null;
    }

    @Override public E findMax() {
        return null;
    }

    @Override public void rebalance() {

    }
}
