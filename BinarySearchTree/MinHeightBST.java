package BinarySearchTree;

import java.util.List;

public class MinHeightBST {
    public static BST minHeightBst(List<Integer> array){
        return constructMinHeightBst(array, 0, array.size()-1);
    }

    public static BST constructMinHeightBst(List<Integer> array, int start, int end){
        if(end < start) return null;
        int mid = (start + end) / 2;
        BST bst = new BST(array.get(mid));
        bst.left = constructMinHeightBst(array, start, mid - 1);
        bst.right = constructMinHeightBst(array, mid + 1, end);
        return bst;
    }

    static class BST{
        int value;
        BST left;
        BST right;

        public BST(int value){
            this.value = value;
            left = null;
            right = null;
        }
    }
}
