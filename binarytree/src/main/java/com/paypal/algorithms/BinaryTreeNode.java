package com.paypal.algorithms;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class BinaryTreeNode<V> {

    private final V value;

    private BinaryTreeNode<V> leftChild;

    private BinaryTreeNode<V> rightChild;

    private BinaryTreeNode<V> parent;

}
