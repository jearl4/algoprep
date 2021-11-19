package LeetCode.General.BinaryTree;

import java.util.LinkedList;
import java.util.List;

import Educative.Tree.DTO.TreeNode;

public class InOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        dfs(root, list);
        return list;
    }
    
    public void dfs(TreeNode node, List<Integer> list){
        if(node == null){
            return;
        }
        dfs(node.left, list);
        list.add(node.val);
        dfs(node.right, list);
    }
}
