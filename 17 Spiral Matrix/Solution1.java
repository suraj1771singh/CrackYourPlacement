import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        int rowStart = 0;
        int rowEnd = n - 1;
        int colStart = 0;
        int colEnd = m - 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i++)
                res.add(matrix[rowStart][i]);
            rowStart++;
            for (int i = rowStart; i <= rowEnd; i++)
                res.add(matrix[i][colEnd]);
            colEnd--;
            for (int i = colEnd; i >= colStart; i--)
                if (rowStart <= rowEnd)
                    res.add(matrix[rowEnd][i]);
            rowEnd--;
            for (int i = rowEnd; i >= rowStart; i--)
                if (colStart <= colEnd)
                    res.add(matrix[i][colStart]);
            colStart++;

        }
        return res;
    }
}