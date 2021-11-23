package LeetCode.General.BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import Educative.Tree.DTO.TreeNode;

public class AverageOfLevels {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            double sum = 0;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                sum += node.val;
                
                if(node.left != null){
                    queue.add(node.left);
                }
                
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            result.add(sum / size);
            sum = 0;
        }
        return result;
    }
}
