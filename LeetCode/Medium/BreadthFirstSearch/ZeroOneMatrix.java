package LeetCode.Medium.BreadthFirstSearch;

import java.util.Arrays;

public class ZeroOneMatrix {
    public int[][] updateMatrix(int[][] mat) {
        if (mat.length == 0) {
            return mat;
        }

        int[][] solution = new int[mat.length][mat[0].length];
        for (int[] arr1 : solution)
            Arrays.fill(arr1, Integer.MAX_VALUE);
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    solution[i][j] = 0;
                } else {
                    for (int k = 0; k < mat.length; k++) {
                        for (int l = 0; l < mat[0].length; l++) {
                            if (mat[k][l] == 0) {
                                solution[i][j] = Math.min(solution[i][j], Math.abs(k - i) + Math.abs(l - j));
                            }
                        }
                    }
                }
            }
        }
        return solution;
    }
}
