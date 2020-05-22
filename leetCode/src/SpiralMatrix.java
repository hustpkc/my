import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author Pario
 * @description 顺时针打印矩阵
 * @date 2020/5/18 17:00
 */
public class SpiralMatrix {
    public static int[] spiralOrder(int[][] matrix) {
        //空特殊处理
        int[] res = {};
        if (matrix == null) {
            return res;
        }
        if (matrix.length <= 0 || matrix[0].length <= 0) {
            return res;
        }

        return help(matrix);

    }

    private static int[] help(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] res = new int[rows * cols];

        int rowStart = 0;
        int rowEnd = rows - 1;
        int colStart = 0;
        int colEnd = cols - 1;

        int curIndex = 0;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            //左上->右上
            for (int i = rowStart, j = colStart; j <= colEnd; j++) {
                res[curIndex++] = matrix[i][j];
            }

            //右上->右下
            for (int i = rowStart + 1, j = colEnd; i <= rowEnd; i++) {
                res[curIndex++] = matrix[i][j];
            }

            //右下->左下
            if (rowStart < rowEnd) {
                for (int i = rowEnd, j = colEnd - 1; j >= colStart; j--) {
                    res[curIndex++] = matrix[i][j];
                }
            }

            //左下->左上
            if (colStart < colEnd) {
                for (int i = rowEnd - 1, j = colStart; i > rowStart; i--) {
                    res[curIndex++] = matrix[i][j];
                }
            }

            rowStart++;
            rowEnd--;
            colStart++;
            colEnd--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] input = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[] res = spiralOrder(input);

    }
}
