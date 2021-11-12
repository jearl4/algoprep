package AlgoExpert.BinarySearchTree;

public class InvertTree {
    public static void invertBinaryTree(BinaryTree tree){
        if(tree == null){
            return;
        }

        switchLeftAndRight(tree);
        invertBinaryTree(tree.left);
        invertBinaryTree(tree.right);
    }

    public static void switchLeftAndRight(BinaryTree root){
        BinaryTree temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value){
            this.value = value;
        }
    }
}
