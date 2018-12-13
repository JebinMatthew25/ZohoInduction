import java.util.ArrayList;

class FindInGrid {
    private Character[][] grid;
    private Integer m, n;

    FindInGrid(Character[][] grid)
    {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
    }

    private Boolean valid(Integer i, Integer j)
    {
        return (i >= 0) && (j >= 0) && (i < m) && (j < n);
    }

    void find(String name) {
        int l = name.length();
        int[][] dirs = {{0, 1}, {1, 0}, {1, 1}};
        ArrayList<Integer[]> path = new ArrayList<Integer[]>();

        for (int[] dir : dirs)
        {
            for (int i = 0; i < m; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    int x=i, y=j;
                    ArrayList<Integer[]> tempPath = new ArrayList<Integer[]>();
                    for (int k = 0; k < l; k++)
                    {
                        if (!valid(x, y) || grid[x][y] != name.charAt(k))
                            break;
                        else
                            tempPath.add(new Integer[] {x, y});
                        x += dir[0];
                        y += dir[1];
                    }
                    if(tempPath.size() == name.length())
                        path = tempPath;
                }
            }
        }

        if(!path.isEmpty())
        {
            System.out.printf("%s \t:", name);
            for (Integer[] pair: path)
                System.out.printf("(%d, %d) ", pair[0], pair[1]);
            System.out.println();
        }
        else
            System.out.printf("%s \t: Nah!\n", name);
    }
}
