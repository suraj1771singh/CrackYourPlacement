import java.util.*;;

class Solution {

    int dirs[][] = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

    public int[][] nearest(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        boolean seen[][] = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    q.add(new int[] { i, j });
                    seen[i][j] = true;
                }
            }
        }
        int cnt = 0;
        while (!q.isEmpty()) {
            int k = q.size();
            while (k-- > 0) {
                
                int p[] = q.poll();
                grid[p[0]][p[1]] = cnt;

                for (int dir[] : dirs) {
                    int x = dir[0] + p[0];
                    int y = dir[1] + p[1];
                    if (x >= 0 && x < n && y >= 0 && y < m && !seen[x][y]) {
                        seen[x][y] = true;
                        q.add(new int[] { x, y });
                    }
                }
            }
            cnt++;
        }
        return grid;
    }
}