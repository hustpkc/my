/**
 * @author Pario
 * @description
 * @date 2020/4/22 9:10
 */
public class RobotMoving {
    public int movingCount(int threshold, int m, int n) {
        if ((threshold < 0 || m <= 0 || n <= 0)) {
            return 0;
        }

        //初始化访问标识矩阵，标识该位置是否访问过，false-未访问
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }

        int count = movingCountCore(threshold, m, n, 0, 0, visited);
        return count;
    }

    private int movingCountCore(int threshold, int rows, int cols, int curRow, int curCol, boolean[][] visited) {
        int count = 0;
        if (check(threshold, rows, cols, curRow, curCol, visited)) {
            visited[curRow][curCol] = true;
            count = 1
                    + movingCountCore(threshold, rows - 1, cols, curRow, curCol, visited)
                    + movingCountCore(threshold, rows, cols + 1, curRow, curCol, visited)
                    + movingCountCore(threshold, rows - 1, cols, curRow, curCol, visited)
                    + movingCountCore(threshold, rows, cols - 1, curRow, curCol, visited);
        }
        return count;
    }

    private boolean check(int threshold, int rows, int cols, int curRow, int curCol, boolean[][] visited) {
        if (curRow < 0 || curRow > rows
                || curCol < 0 || curCol > cols
                || visited[curRow][curCol]
                || getDigitSum(curRow) + getDigitSum(curCol) > threshold) {
            return false;
        }
        return true;
    }

    /**
     * 计算数字的数位之和，eg: getDigitSum(35) = 8,getDigitSum(125) = 8
     *
     * @param number
     * @return
     */
    private int getDigitSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
