package com.group2.bst.model;

public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> implements BinarySearchTreeADT<E> {

    public BinarySearchTree() {
        super();
    }

    @Override public boolean insert(E element) {
        if (getRoot() == null) {
            setRoot(new BinarySearchTreeNode<>(element));
            return true;
        }

        BinaryTreeNode<E> node = getRoot();
        while (true) {
            if (element.compareTo(node.getElement()) < 0) {
                if (node.getLeftChild() == null) {
                    node.addLeftChild(new BinarySearchTreeNode<>(element));
                    return true;
                }
                node = node.getLeftChild();
            }
            else if (element.compareTo(node.getElement()) > 0) {
                if (node.getRightChild() == null) {
                    node.addRightChild(new BinarySearchTreeNode<>(element));
                    return true;
                }
                node = node.getRightChild();
            }
            else {
                return false;
            }
        }
    }

    @Override public boolean removeElement(E element) {
        if (getRoot() == null) {
            return false;
        }

        BinaryTreeNode<E> node = getRoot();
        BinaryTreeNode<E> parent = null;
        boolean isLeft = false;

        while (node != null) {

            // travel left
            if (element.compareTo(node.getElement()) < 0) {
                parent = node;
                node = node.getLeftChild();
                isLeft = true;
            }

            // travel right
            else if (element.compareTo(node.getElement()) > 0) {
                parent = node;
                node = node.getRightChild();
                isLeft = false;
            }

            // element found
            else {

                // 2 children case
                if (node.getLeftChild() != null && node.getRightChild() != null) {
                    node = node.getRightChild();
                    while (node.getLeftChild() != null)
                        node = node.getLeftChild();

                    if (parent == null) {
                        node.addLeftChild(getRoot().getLeftChild());
                        setRoot(node);
                    }
                    else if (isLeft) {
                        node.addLeftChild(parent.getLeftChild().getLeftChild());
                        parent.addLeftChild(node);
                    }
                    else {
                        node.addLeftChild(parent.getRightChild().getLeftChild());
                        parent.addRightChild(node);
                    }
                }

                // 1 child case
                else if (node.getLeftChild() != null || node.getRightChild() != null) {
                    if (parent == null)
                        setRoot(node.getLeftChild() != null ? node.getLeftChild() : node.getRightChild());
                    else if (isLeft)
                        parent.addLeftChild(node.getLeftChild() != null ? node.getLeftChild() : node.getRightChild());
                    else
                        parent.addRightChild(node.getLeftChild() != null ? node.getLeftChild() : node.getRightChild());
                }

                // no child case
                else {
                    if (parent == null)
                        setRoot(null);
                    else if (isLeft)
                        parent.addLeftChild(null);
                    else
                        parent.addRightChild(null);
                }

                return true;
            }
        }

        return false;
    }

    @Override public E findMin() {
        if (getRoot() == null) {
            return null;
        }

        BinaryTreeNode<E> node = getRoot();
        while (node.getLeftChild() != null) {
            node = node.getLeftChild();
        }

        return node.getElement();
    }

    @Override public E findMax() {
        if (getRoot() == null) {
            return null;
        }

        BinaryTreeNode<E> node = getRoot();
        while (node.getRightChild() != null) {
            node = node.getRightChild();
        }

        return node.getElement();
    }

    @Override public boolean contains(E element) {
        if (getRoot() == null) {
            return false;
        }

        BinaryTreeNode<E> node = getRoot();
        while (node != null) {
            if (element.compareTo(node.getElement()) < 0) {
                node = node.getLeftChild();
            }
            else if (element.compareTo(node.getElement()) > 0) {
                node = node.getRightChild();
            }
            else {
                return true;
            }
        }

        return false;
    }

    @Override public void rebalance() {

    }
}
