package com.group2.bst.model;

public class BinaryTreeNode<E extends Comparable<E>> {
    private E element;
    private BinaryTreeNode<E> leftChild;
    private BinaryTreeNode<E> rightChild;

    public BinaryTreeNode() {

    }

    public void setElement(E element) {
        this.element = element;
    }

    public E getElement() {
        return element;
    }

    public void addLeftChild(BinaryTreeNode<E> left) {
        this.leftChild = left;
    }

    public void addRightChild(BinaryTreeNode<E> right) {
        this.rightChild = right;
    }

    public BinaryTreeNode<E> getLeftChild(){
        return leftChild;
    }

    public BinaryTreeNode<E> getRightChild() {
        return rightChild;
    }

}
