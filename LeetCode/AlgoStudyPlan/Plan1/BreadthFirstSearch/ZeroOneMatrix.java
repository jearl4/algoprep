package LeetCode.AlgoStudyPlan.Plan1.BreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {
    public int[][] updateMatrix(int[][] mat) {
        if (mat.length == 0) {
            return mat;
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[] { i, j });
                } else {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] d : dirs) {
                int r = cell[0] + d[0];
                int c = cell[1] + d[1];
                if (r < 0 || r >= mat.length || c < 0 || c >= mat[0].length || mat[r][c] <= mat[cell[0]][cell[1]] + 1)
                    continue;
                queue.add(new int[] { r, c });
                mat[r][c] = mat[cell[0]][cell[1]] + 1;
            }
        }
        return mat;
    }
}
