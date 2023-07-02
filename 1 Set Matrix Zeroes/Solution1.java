class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean firstcol = false;
        boolean firstrow = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0)
                        firstrow = true;
                    if (j == 0)
                        firstcol = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }
        if (firstrow)
            for (int i = 0; i < m; i++)
                matrix[0][i] = 0;
        if (firstcol)
            for (int i = 0; i < n; i++)
                matrix[i][0] = 0;

    }
}
// Time complexity : O(n*m)
// Spac complexity : O(1)