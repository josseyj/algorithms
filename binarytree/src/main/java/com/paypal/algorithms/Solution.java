package com.paypal.algorithms;

import java.util.function.Supplier;

class Solution {
    public boolean isBalanced(TreeNode root) {
        return getBalancedStatus(root).balanced;
    }

    public Status getBalancedStatus(TreeNode root) {
        if (root == null) {
            return Status.builder().balanced(true).height(0).build();
        }
        Status leftStatus = getBalancedStatus(root.left);
        Status rightStatus = getBalancedStatus(root.right);
        return Status.combine(leftStatus, rightStatus);
    }

    private static class Status {
        private final boolean balanced;
        private final int height;

        Status(boolean balanced, int height) {
            this.balanced = balanced;
            this.height = height;
        }

        public static Status combine(Supplier<Status>... statusSuppliers) {
            Status status = Status.builder().balanced(true).height(0).build();
            for (Supplier<Status> statusSupplier : statusSuppliers) {
                if (!status.balanced) {
                    break;
                }
                status = combine(status, statusSupplier.get());
            }
            return status;
        }


        public static Status combine(Status status1, Status status2) {
            return Status.builder()
                    .balanced(status1.balanced && status2.balanced && Math.abs(status1.height - status2.height) < 2)
                    .height(Math.max(status1.height, status2.height) + 1)
                    .build();
        }

        public static StatusBuilder builder() {
            return new StatusBuilder();
        }

        public static class StatusBuilder {
            private boolean balanced;
            private int height;

            StatusBuilder() {
            }

            public StatusBuilder balanced(boolean balanced) {
                this.balanced = balanced;
                return this;
            }

            public StatusBuilder height(int height) {
                this.height = height;
                return this;
            }

            public Status build() {
                return new Status(balanced, height);
            }

            public String toString() {
                return "Solution.Status.StatusBuilder(balanced=" + this.balanced + ", height=" + this.height + ")";
            }
        }
    }
}