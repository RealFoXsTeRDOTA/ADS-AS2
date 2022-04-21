package com.group2.bst.model;

import java.util.ArrayList;

public interface BinaryTreeADT<E> {
    BinaryTreeNode<E> getRoot();
    void setRoot(BinaryTreeNode<E> root);
    boolean isEmpty();
    int size();
    boolean contains(E element);
    ArrayList<E> inOrder();
    ArrayList<E> preOrder();
    ArrayList<E> postOrder();
    ArrayList<E> levelOrder();
    int height();
}
