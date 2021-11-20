package LeetCode.General.BinaryTree;

import java.util.ArrayDeque;
import java.util.Deque;

import Educative.Tree.DTO.TreeNode;

public class UnivaluedTree {
    public boolean isUnivalTree(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.val != root.val){
                return false;
            }
            
            if(node.left != null)
                stack.push(node.left);
            if(node.right != null)
                stack.push(node.right);
        }
        return true;
    }
}
