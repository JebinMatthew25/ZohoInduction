import java.lang.Math;

class QueenStrikesAgain {
    private Integer m, n, qx, qy;
    private Character[][] board;

    QueenStrikesAgain(int m, int n)
    {
        this.m = m;
        this.n = n;
        board = new Character[m][n];
        for(int i=0; i < m; i++)
            for(int j=0; j < n; j++)
                board[i][j] = '.';
    }

    void show()
    {
        for(int i=0; i < m; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(board[i][j]);
            System.out.println();
        }
        System.out.println();
    }

    void add_queen(Integer[] queen)
    {
        qx = queen[0];
        qy = queen[1];
        board[qx][qy] = 'Q';
    }

    void add_obstacles(Integer n, Integer[][] obs)
    {
        for (int i=0; i<n; i++)
            board[obs[i][0]][obs[i][1]] = 'X';
    }

    private Boolean valid(Integer i, Integer j)
    {
        return (i >= 0) && (j >= 0) && (i < m) && (j < n) && board[i][j] == '.';
    }

    void attack()
    {
        int count = 0;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0},
                {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        for (int[] dir: dirs) {
            int [] temp = {qx, qy};
            for (int i = 1; i <= Math.max(m, n); i++){
                temp[0] += dir[0];
                temp[1] += dir[1];
                if (valid(temp[0], temp[1]))
                    count += 1;
                else break;

            }
        }
        System.out.println(count);
    }
}
