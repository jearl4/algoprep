package AlgoExpert.BinarySearchTree;

import java.util.List;

public class PreOrderReconstruct {
    // given BST class
    static class BST {
        int value;
        BST left = null;
        BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    // custom class to track tree
    static class TreeInfo {
        public int rootIndex;

        public TreeInfo(int rootIndex) {
            this.rootIndex = rootIndex;
        }
    }

    public BST reconstructBst(List<Integer> array) {
        TreeInfo treeInfo = new TreeInfo(0);
        return reconstructBstFromRange(Integer.MIN_VALUE, Integer.MAX_VALUE, array, treeInfo);
    }

    public BST reconstructBstFromRange(int lowerBound, int upperBound, List<Integer> array, TreeInfo currentSubtree) {
        if (currentSubtree.rootIndex == array.size()) {
            return null;
        }

        int rootValue = array.get(currentSubtree.rootIndex);
        if (rootValue < lowerBound || rootValue >= upperBound) {
            return null;
        }

        currentSubtree.rootIndex += 1;
        BST leftSubTree = reconstructBstFromRange(lowerBound, rootValue, array, currentSubtree);
        BST rightSubTree = reconstructBstFromRange(rootValue, upperBound, array, currentSubtree);

        BST bst = new BST(rootValue);
        bst.left = leftSubTree;
        bst.right = rightSubTree;
        return bst;
    }
}
