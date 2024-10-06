package leetcode.patterns.binary.tree.depth.first;

import java.util.ArrayList;
import java.util.List;

//257. Binary Tree Paths
//Given the root of a binary tree, return all root-to-leaf paths in any order.
//A leaf is a node with no children.
//Input: root = [1,2,3,null,5]
//Output: ["1->2->5","1->3"]
//Example 2:
//
//Input: root = [1]
//Output: ["1"]
public class BinaryTreePath {

 public static List<String> binaryTreePaths(TreeNode root) {
  List<String> result = new ArrayList<>();
  //Processing the root node deep till the left side
     String data = String.valueOf(root.val);
     if(root.left !=null) {
         String leftResult = returnNodeOrder(root.left);
         result.add(data+"->"+leftResult);
     } if(root.right !=null) {
         String rightResult = returnNodeOrder(root.right);
         result.add(data+"->"+rightResult);
     }
     return result;
  }

  private static String returnNodeOrder(TreeNode root) {
     StringBuilder data = new StringBuilder(String.valueOf(root.val));
      while(root !=null){
          if(root.left != null){
              root = root.left;
              data.append("->").append(root.val);
          } else if(root.right !=null) {
              root =  root.right;
              data.append("->").append(root.val);
          } else {
              root = null;
          }
      }
      return data.toString();
  }

  public static void main(String[] args) {
     TreeNode root = new TreeNode(1,new TreeNode(2,null,new TreeNode(5)),new TreeNode(3,null,null));
     List<String> result = binaryTreePaths(root);
      for (String outputOrder: result) {
          System.out.println(outputOrder);
      }
  }

static class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int val) { this.val = val; }
  TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

}
