import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import DTO.TreeNode;

public class CountPathsForSum {
    public static int findPathsForSum(TreeNode root, int sum) {
        List<Integer> currentPath = new LinkedList<>();
        return findPathsForSumRecursive(root, sum, currentPath);
    }

    private static int findPathsForSumRecursive(TreeNode currentNode, int sum, List<Integer> currentPath) {
        if (currentNode == null) {
            return 0;
        }

        int pathCount = 0, pathSum = 0;
        currentPath.add(currentNode.val);

        ListIterator<Integer> pathIterator = currentPath.listIterator(currentPath.size());
        while (pathIterator.hasPrevious()) {
            pathSum += pathIterator.previous();
            if (pathSum == sum) {
                pathCount++;
            }
        }

        pathCount += findPathsForSumRecursive(currentNode.left, sum, currentPath);
        pathCount += findPathsForSumRecursive(currentNode.right, sum, currentPath);
        currentPath.remove(currentPath.size() - 1);
        return pathCount;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + findPathsForSum(root, 11));
    }
}
