package leetcode.patterns.binary.tree.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 94. Binary Tree Inorder Traversal
//Given the root of a binary tree, return the inorder traversal of its nodes' values.
//Example 1:
//Input: root = [1,null,2,3]
//Output: [1,3,2]
public class BinaryTreeInOrder {

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode inputRoot = new TreeNode(1,null,new TreeNode(2,new TreeNode(3),null));
        List<Integer> result = inorderTraversal(inputRoot);
        for (Integer nodeValue: result) {
            System.out.println(nodeValue);
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

