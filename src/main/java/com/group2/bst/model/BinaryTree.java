package com.group2.bst.model;

import java.util.ArrayList;

public class BinaryTree<E extends Comparable<E>> implements BinaryTreeADT<E> {

    private BinaryTreeNode<E> root;
    private int size;

    @Override
    public BinaryTreeNode<E> getRoot() {
        return root;
    }

    @Override
    public void setRoot(BinaryTreeNode<E> root) {
        this.root = root;
    }

    @Override
    public boolean isEmpty() {
        return root == null || root.getElement() == null;
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(BinaryTreeNode<E> r) {
        if(r == null || r.getElement() == null) {
            return 0;
        }
        else {
            return size(r.getLeftChild()) + size(r.getRightChild()) +1;
        }
    }

    @Override
    public boolean contains(E element) {
        return contains(root, element);
    }

    private boolean contains(BinaryTreeNode<E> root, E element) {
        if(root == null)
            return false;
        return root.getElement().equals(element) || contains(root.getLeftChild(), element) ||
                contains(root.getRightChild(), element);
    }

    @Override
    public ArrayList<E> inOrder() {
        ArrayList<E> elements = new ArrayList<>();
        return inOrder(elements, root);
    }

    private ArrayList<E> inOrder(ArrayList<E> list, BinaryTreeNode<E> root) {
        if(root == null) {
            return list;
        }
        inOrder(list,root.getLeftChild());
        list.add(root.getElement());
        inOrder(list,root.getRightChild());
        return list;
    }

    @Override
    public ArrayList<E> preOrder() {
        ArrayList<E> elements = new ArrayList<>();
        return preOrder(elements, root);
    }

    private ArrayList<E> preOrder(ArrayList<E> list, BinaryTreeNode<E> root) {
        if(root == null) {
            return list;
        }
        list.add(root.getElement());
        preOrder(list,root.getLeftChild());
        preOrder(list,root.getRightChild());
        return list;
    }

    @Override
    public ArrayList<E> postOrder() {
        ArrayList<E> elements = new ArrayList<>();
        return postOrder(elements, root);
    }

    private ArrayList<E> postOrder(ArrayList<E> list, BinaryTreeNode<E> root) {
        if(root == null) {
            return list;
        }
        postOrder(list,root.getLeftChild());
        postOrder(list,root.getRightChild());
        list.add(root.getElement());
        return list;
    }

    @Override
    public ArrayList<E> levelOrder() {
        ArrayList<E> elements = new ArrayList<>();
        return levelOrder(elements, root);
    }

    private ArrayList<E> levelOrder(ArrayList<E> list, BinaryTreeNode<E> root) {
        if(root == null) {
            return list;
        }
        int height = height(root);
        for(int i = 0; i < height; i++) {
            atCurrentLevel(list, root, i);
        }
        return list;
    }

    private void atCurrentLevel(ArrayList<E> list,BinaryTreeNode<E> root, int level) {
        if(root == null)
            return;
        else if(level > 1) {
            list.add(root.getElement());
            atCurrentLevel(list, root.getLeftChild(), level - 1);
            atCurrentLevel(list, root.getRightChild(), level - 1);
        }
    }

    @Override
    public int height() {
        if(root == null)
            return 0;
        return height(root);
    }

    private int height(BinaryTreeNode<E> root) {
        int leftHeight = height(root.getLeftChild());
        int rightHeight = height(root.getRightChild());

        if(leftHeight > rightHeight)
            return leftHeight + 1;
        else
            return rightHeight + 1;
    }
}
