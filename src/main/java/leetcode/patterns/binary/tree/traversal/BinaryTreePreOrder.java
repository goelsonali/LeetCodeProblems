package leetcode.patterns.binary.tree.traversal;

import java.util.ArrayList;
import java.util.List;

// 144. Binary Tree Preorder Traversal
//Given the root of a binary tree, return the preorder traversal of its nodes' values.
//Example 1:
//Input: root = [1,null,2,3]
// Output: [1,2,3]

public class BinaryTreePreOrder {
    //Preorder traversal is - root, left, right
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        while (root != null) {
            list.add(root.val);
            if(root.left !=null){
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode inputRoot = new TreeNode(1,null,new TreeNode(2,new TreeNode(3),null));
        List<Integer> result = preorderTraversal(inputRoot);
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

