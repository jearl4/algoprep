package LeetCode.General.BinaryTree;

import java.util.Stack;

import Educative.Tree.DTO.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class RangeSum {
    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node != null){
                if(node.val >= low && node.val <= high){
                    sum += node.val;
                }
                
                if(node.val > low){
                    stack.push(node.left);
                }
                
                if(node.val < high){
                    stack.push(node.right);
                }
            }
        }
        return sum;
    }
}
