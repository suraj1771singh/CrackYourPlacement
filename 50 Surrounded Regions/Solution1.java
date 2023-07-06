class Solution {
    int dirs[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    int n;
    int m;

    public void solve(char[][] board) {
        int n = board.length, m = board[0].length;
        // from top
        for (int i = 0; i < m; i++)
            if (board[0][i] == 'O')
                dfs(0, i, board);
        // from bottom
        for (int i = 0; i < m; i++)
            if (board[n - 1][i] == 'O')
                dfs(n - 1, i, board);
        // from left
        for (int i = 0; i < n; i++)
            if (board[i][0] == 'O')
                dfs(i, 0, board);
        // from right
        for (int i = 0; i < n; i++)
            if (board[i][m - 1] == 'O')
                dfs(i, m - 1, board);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }

    }

    private void dfs(int i, int j, char[][] board) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'O')
            return;
        board[i][j] = '#';
        dfs(i - 1, j, board);
        dfs(i + 1, j, board);
        dfs(i, j - 1, board);
        dfs(i, j + 1, board);
    }
}
// Time complexity : O(n*m)