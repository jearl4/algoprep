package Educative.KWayMerge;

import java.util.PriorityQueue;

class Node {
    int row;
    int col;
  
    Node(int row, int col) {
      this.row = row;
      this.col = col;
    }
  }

public class KthSmallestInSortedMatrix {
    public static int findKthSmallest(int[][] matrix, int k) {
        PriorityQueue<Node> minHeap = new PriorityQueue<Node>((n1, n2) -> matrix[n1.row][n1.col] - matrix[n2.row][n2.col]);
        for (int i = 0; i < matrix.length && i < k; i++) {
            minHeap.add(new Node(1, 0));
        }

        int numberCount = 0, result = 0;
        while (!minHeap.isEmpty()) {
            Node node = minHeap.poll();
            result = matrix[node.row][node.col];
            if (++numberCount == k) {
                break;
            }
            node.col++;
            if (matrix[0].length > node.col) {
                minHeap.add(node);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int matrix[][] = { { 2, 6, 8 }, { 3, 7, 10 }, { 5, 8, 11 } };
        int result = KthSmallestInSortedMatrix.findKthSmallest(matrix, 5);
        System.out.print("Kth smallest number is: " + result);
        System.out.println();
    }
}
