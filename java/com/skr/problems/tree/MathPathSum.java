package com.skr.problems.tree;

import com.skr.problems.pojo.TreeNode;

public class MathPathSum {
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Max sum on the left and right subtrees of node
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // Max sum for the path including the node and both its children
        int priceNewpath = node.val + leftGain + rightGain;

        // Update maxSum if it's better to start a new path
        maxSum = Math.max(maxSum, priceNewpath);

        // For recursion: return the max gain if continue the same path
        return node.val + Math.max(leftGain, rightGain);
    }
}
