package LeetCode.Explore.HashTable;

import java.util.HashSet;

public class ValidSudoku36 {
    public boolean isValidSudoku(char[][] board) {
        int size = 9;

        HashSet<Character>[] rows = new HashSet[size];
        HashSet<Character>[] cols = new HashSet[size];
        HashSet<Character>[] boxes = new HashSet[size];

        for (int r = 0; r < size; r++) {
            rows[r] = new HashSet<Character>();
            cols[r] = new HashSet<Character>();
            boxes[r] = new HashSet<Character>();
        }

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                char val = board[r][c];

                if (val == '.') {
                    continue;
                }

                if (rows[r].contains(val)) {
                    return false;
                }
                rows[r].add(val);

                if (cols[c].contains(val)) {
                    return false;
                }
                cols[c].add(val);

                int index = (r / 3) * 3 + c / 3;
                if (boxes[index].contains(val)) {
                    return false;
                }
                boxes[index].add(val);
            }
        }
        return true;
    }
}
