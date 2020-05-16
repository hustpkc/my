import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Pario
 * @description
 * @date 2020/4/22 19:37
 */
public class Queen {
    static List<List<String>> res = new ArrayList<>();

    public static List<List<String>> solveNQueens(int n) {
        if (n < 1) {
            return res;
        }
        List<Integer> list = new ArrayList<Integer>();

        help(0, n, list);
        return res;
    }

    /**
     * @param row
     * @param n
     * @param list 当前的解决方案，即上一行结束时的解决方案，[1,2,3,0]代表0,1,2,3行的皇后分别在1,2,3,0列
     */
    private static void help(int row, int n, List<Integer> list) {
        if (row == n) {
            List<String> strList = new ArrayList<>();
            for (Integer num : list) {
                char[] t = new char[n];
                Arrays.fill(t, '.');
                t[num] = 'Q';
                strList.add(new String(t));
            }
            res.add(strList);
            return;

        }
        //每一列都尝试一下
        for (int col = 0; col < n; col++) {
            //当前列是否合法
            if (!list.contains(col)) {
                //左斜与右协是否哈法
                if (!isDiagonalAttack(list, col)) {
                    list.add(col);
                    help(row + 1, n, list);
                    //回溯
                    list.remove(list.size() - 1);
                }
            }

        }

    }

    private static boolean isDiagonalAttack(List<Integer> currentQueen, int i) {
        int currentRow = currentQueen.size();
        int currentCol = i;
        //判断每一行的皇后的情况
        for (int row = 0; row < currentQueen.size(); row++) {
            //左上角的对角线和右上角的对角线，差要么相等，要么互为相反数，直接写成了绝对值
            if (Math.abs(currentRow - row) == Math.abs(currentCol - currentQueen.get(row))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        System.out.println(solveNQueensMy(4).toString());
        char[] a={'y','o','u','k'};
        System.out.println(a.toString());
        System.out.println(new String(a));
        System.out.println(Arrays.toString(a));
        System.out.println(String.valueOf(a));
        System.out.println(Arrays.copyOf(a,a.length));
    }


    //我的复现解法
    public static List<List<String>> solveNQueensMy(int n) {
        ArrayList<List<String>> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }
        ArrayList<Integer> list = new ArrayList<>();
        helpMy(0, n, res, list);
        return res;
    }

    private static void helpMy(int curRow, int n, ArrayList<List<String>> res, ArrayList<Integer> cur) {
        if (curRow >= n) {
            ArrayList<String> temp = new ArrayList<>();
            for (Integer s : cur) {
                char[] chars = new char[n];
                Arrays.fill(chars, '.');
                chars[s] = 'Q';
                temp.add(new String(chars));
            }
            res.add(temp);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (!cur.contains(col) && satisfyCur(curRow, col, cur)) {
                cur.add(col);
                helpMy(curRow + 1, n, res, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }

    private static boolean satisfyCur(int curRow, int col, ArrayList<Integer> cur) {
//        int curRow = cur.size();
        for (int i = 0; i < cur.size(); i++) {
            if ((curRow - i) == (col - cur.get(i)) || (curRow - i) == (cur.get(i) - col)) {
                return false;
            }
        }
        return true;
    }
}
