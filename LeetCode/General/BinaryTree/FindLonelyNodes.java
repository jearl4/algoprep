package LeetCode.General.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class FindLonelyNodes {
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        dfs(root, nodes);
        return nodes;
    }
    
    public void dfs(TreeNode node, List<Integer> nodes){
        if(node == null){
            return;
        }
        
        if(node.left == null && node.right != null){
             nodes.add(node.right.val);
        }
        if(node.right == null && node.left != null){
             nodes.add(node.left.val);
        }
        
        dfs(node.left, nodes);
        dfs(node.right, nodes);
    }
}
