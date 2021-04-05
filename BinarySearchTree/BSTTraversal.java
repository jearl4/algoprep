package BinarySearchTree;

import java.util.List;

public class BSTTraversal {
    public static List<Integer> inOrderTraversal(BST tree, List<Integer> array) {
        if(tree.left != null){
            inOrderTraversal(tree.left, array);
        }
        array.add(tree.value);
        if(tree.right != null){
            inOrderTraversal(tree.right, array);
        }
        return array;
    }

    public static List<Integer> preOrderTraversal(BST tree, List<Integer> array) {
        array.add(tree.value);
        if(tree.left != null){
            preOrderTraversal(tree.left, array);
        }
        if(tree.right != null){
            preOrderTraversal(tree.right, array);
        }
        return array;
    }

    public static List<Integer> postOrderTraversal(BST tree, List<Integer> array) {
        if(tree.left != null){
            postOrderTraversal(tree.left, array);
        }
        if(tree.right != null){
            postOrderTraversal(tree.right, array);
        }
        array.add(tree.value);
        return array;
    }

    static class BST{
        public int value;
        public BST left;
        public BST right;

        public BST(int value){
            this.value = value;
        }
    }
}
