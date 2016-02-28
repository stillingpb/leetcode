package round2;

public class test200 {
    public static void main(String[] args) {
        System.out.println(new test200().numIslands(new char[][]{
                "11000".toCharArray(),
                "11000".toCharArray(),
                "00100".toCharArray(),
                "00011".toCharArray(),
        }));
        System.out.println(new test200().numIslands(new char[][]{
                "11110".toCharArray(),
                "11010".toCharArray(),
                "11000".toCharArray(),
                "00000".toCharArray(),
        }));
        System.out.println(new test200().numIslands(new char[][]{
                "1".toCharArray(),
        }));
        System.out.println(new test200().numIslands(new char[][]{
                "01".toCharArray(),
                "10".toCharArray(),
        }));
    }

    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    traverse(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void traverse(char[][] grid, int i, int j) {
        if (grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        if (i > 0)
            traverse(grid, i - 1, j);
        if (i < grid.length - 1)
            traverse(grid, i + 1, j);
        if (j > 0)
            traverse(grid, i, j - 1);
        if (j < grid[0].length - 1)
            traverse(grid, i, j + 1);
    }
}
