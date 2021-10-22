package Subsets;

import java.util.ArrayList;
import java.util.List;

import Subsets.DTO.TreeNode;

public class Challenge2 {
    public static List<TreeNode> indUniqueTrees(int num){
        if (num <= 0) {
            return new ArrayList<TreeNode>();
        }
        return findUniqueTreesRecursive(1, num);
    }

    private static List<TreeNode> findUniqueTreesRecursive(int start, int end) {
        List<TreeNode> result = new ArrayList<>();

        if (start > end) {
            result.add(null);
            return result;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftSubtrees = findUniqueTreesRecursive(start, i - 1);
            List<TreeNode> rightSubtrees = findUniqueTreesRecursive(i + 1, end);

            for (TreeNode leftTree : leftSubtrees) {
                for (TreeNode rightTree : rightSubtrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    result.add(root);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<TreeNode> result = indUniqueTrees(2);
        System.out.print("Total trees: " + result.size());
        System.out.println();
    }
}
