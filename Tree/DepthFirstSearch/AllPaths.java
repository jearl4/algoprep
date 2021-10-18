package Tree.DepthFirstSearch;

import Tree.DTO.TreeNode;
import java.util.*;

public class AllPaths {
    public static List<List<Integer>> findAllPaths(TreeNode root) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        findAllPathsRecursive(root, path, allPaths);
        return allPaths;
    }

    private static void findAllPathsRecursive(TreeNode currentNode, List<Integer> path, List<List<Integer>> allPaths) {
        if (currentNode == null) {
            return;
        }

        path.add(currentNode.val);
        if (currentNode.left == null && currentNode.right == null) {
            allPaths.add(new ArrayList<Integer>(path));
        } else {
            findAllPathsRecursive(currentNode.left, path, allPaths);
            findAllPathsRecursive(currentNode.right, path, allPaths);
        }
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<List<Integer>> result = findAllPaths(root);
        System.out.println("Tree paths : " + result);
    }
}
