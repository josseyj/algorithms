package com.paypal.algorithms;

public class BinaryTree<V extends Comparable<V>> {

    private BinaryTreeNode<V> root;

    public void addValue(V value) {
        if (root == null) {
            root = new BinaryTreeNode<V>(value);
        } else {
            addChild(root, value);
        }
    }

    private void addChild(BinaryTreeNode<V> node, V value) {
        int result = node.getValue().compareTo(value);
        if (result > 0) {
            addRightChild(node, value);
        } else if (result < 0) {
            addLeftChild(node, value);
        }
    }

    private void addLeftChild(BinaryTreeNode<V> node, V value) {
        if (node.getLeftChild() == null) {
            BinaryTreeNode<V> newNode = new BinaryTreeNode<>(value);
            newNode.setParent(node);
            node.setLeftChild(newNode);
        } else {
            addChild(node.getLeftChild(), value);
        }
    }

    private void addRightChild(BinaryTreeNode<V> node, V value) {
        if (node.getRightChild() == null) {
            BinaryTreeNode<V> newNode = new BinaryTreeNode<>(value);
            newNode.setParent(node);
            node.setRightChild(newNode);
        } else {
            addChild(node.getRightChild(), value);
        }
    }
}
