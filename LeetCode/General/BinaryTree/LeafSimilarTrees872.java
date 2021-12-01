package LeetCode.General.BinaryTree;

import java.util.HashSet;
import java.util.Set;

import Educative.Tree.DTO.TreeNode;

/**
 * LeafSimilarTrees872
 */
public class LeafSimilarTrees872 {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Set<Integer> tree1 = new HashSet<Integer>();
        Set<Integer> tree2 = new HashSet<>();

        dfs(root1, tree1);
        dfs(root2, tree2);

        return tree1.equals(tree2);
    }

    public void dfs(TreeNode node, Set<Integer> leafValues) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                leafValues.add(node.val);
            }

            dfs(node.left, leafValues);
            dfs(node.right, leafValues);
        }
    }
}