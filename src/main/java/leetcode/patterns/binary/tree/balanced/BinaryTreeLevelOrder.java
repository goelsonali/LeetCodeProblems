package leetcode.patterns.binary.tree.balanced;

import java.util.*;

//102. Binary Tree Level Order Traversal
//Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
//Input: root = [3,9,20,null,null,15,7]
//Output: [[3],[9,20],[15,7]]

public class BinaryTreeLevelOrder {
    //Traversal is - from left to right, level by level
    //Algo
    //1. Use queue to keep track of all the nodes at each level.
    //2. Traverse each level and add the children of the current nodes to the queue.
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root==null) {
            return list;
        }
        queue.add(root);
        while (!queue.isEmpty()){
            int level = queue.size();
            List<Integer> currentLevelValues = new ArrayList<>();
            for(int i = 0; i<level; i++) {
                if(queue.peek().left !=null){
                    queue.add(queue.peek().left);
                } if(queue.peek().right !=null){
                    queue.add(queue.peek().right);
                }
                currentLevelValues.add(queue.remove().val);
            }
            list.add(currentLevelValues);
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode inputRoot = new TreeNode(3,new TreeNode(9),new TreeNode(20,new TreeNode(15),new TreeNode(7)));
        List<List<Integer>> result = levelOrder(inputRoot);
        result.forEach(l-> l.forEach(System.out::println));
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

