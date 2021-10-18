package Tree;
// takes binary tree and return diameter. Diameter is the lenght of the longest path even if that path doesnt pass through the root
public class TreeDiameter {
    static class BinaryTree{
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value){
            this.value = value;
        }
    }

    public class TreeInfo{
        public int height;
        public int diameter;

        public TreeInfo(int diameter, int height){
            this.diameter = diameter;
            this.height = height;
        }
    }

    public int binaryTreeDiameter(BinaryTree tree){
        return getTreeInfo(tree).diameter;
    }

    public TreeInfo getTreeInfo(BinaryTree tree){
        if(tree == null){
            return new TreeInfo(0, 0);
        }

        TreeInfo leftTreeInfo = getTreeInfo(tree.left);
        TreeInfo righTreeInfo = getTreeInfo(tree.right);

        int longestPathThroughRoot = leftTreeInfo.height + righTreeInfo.height;
        int maxDiameterSoFar = Math.max(leftTreeInfo.diameter, righTreeInfo.diameter);
        int currentDiamter = Math.max(longestPathThroughRoot, maxDiameterSoFar);
        int currentHeight = 1 + Math.max(leftTreeInfo.height, righTreeInfo.height);

        return new TreeInfo(currentDiamter, currentHeight);
    }
}
