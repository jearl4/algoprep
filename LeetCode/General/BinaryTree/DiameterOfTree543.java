package LeetCode.General.BinaryTree;

public class DiameterOfTree543 {
    int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        dfs(root);
        return diameter;
    }
    
    public int dfs(TreeNode node){
        if(node == null){
            return 0;
        }
        
        int leftPath = dfs(node.left);
        int rightPath = dfs(node.right);
        diameter = Math.max(diameter, leftPath+ rightPath);
        
        return Math.max(leftPath, rightPath) + 1;
    }
}
