package com.group2.bst;

import com.group2.bst.model.BinaryTree;
import com.group2.bst.model.BinaryTreeNode;

import java.util.ArrayList;
import java.util.Objects;


public class Helper<E extends Comparable<E>> {

    public  BinaryTree<E> getTreeFromList(E[] list){
        return new BinaryTree<>(getTreeNode(list, 0), list.length);
    }

    private BinaryTreeNode<E> getTreeNode(E[] list, int index){
        if(index >= list.length) return null;

        return new BinaryTreeNode<E>(list[index], getTreeNode(list, 2*index + 1), getTreeNode(list, 2*index + 2));
    }

    public ArrayList<E> removeNulls(ArrayList<E> list){
        list.removeIf(Objects::isNull);
        return list;
    }
}
