class Solution {
    int n;
    int m;
    int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (search(1, i, j, new boolean[n][m], board, word))
                        return true;
                }
            }
        }
        return false;
    }

    boolean search(int ind, int i, int j, boolean seen[][], char board[][], String word) {
        if (ind >= word.length())
            return true;
        seen[i][j] = true;
        for (int dir[] : dirs) {
            int nr = dir[0] + i;
            int nc = dir[1] + j;
            if (nr >= 0 && nr < n && nc >= 0 && nc < m && !seen[nr][nc] && board[nr][nc] == word.charAt(ind)) {
                if (search(ind + 1, nr, nc, seen, board, word))
                    return true;
            }
        }
        seen[i][j] = false;
        return false;
    }
}
// Time complexity : O(n*m*len)