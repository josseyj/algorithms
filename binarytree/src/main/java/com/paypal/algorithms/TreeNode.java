package com.paypal.algorithms;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    public TreeNode left(TreeNode left) {
        this.left = left;
        return this;
    }

    public TreeNode right(TreeNode right) {
        this.right = right;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(val);

        if (left != null || right != null) {
            builder.append("[");

            if (left != null) {
                builder.append(left);
                if (right != null) {
                    builder.append(",");
                }
            }

            if (right != null) {
                builder.append(right);
            }
            builder.append("]");
        }
        return builder.toString();
    }
}