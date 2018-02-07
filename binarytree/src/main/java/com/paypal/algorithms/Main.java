package com.paypal.algorithms;

import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0)
                .left(new TreeNode(1).left(new TreeNode(3).right(new TreeNode(4))))
                .right(new TreeNode(2).left(new TreeNode(5).right(new TreeNode(6))));

        System.out.println(root);
        System.out.println(new Solution().isBalanced(root));
    }
}
