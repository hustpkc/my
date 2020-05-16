/**
 * @author Pario
 * @description
 * @date 2020/4/22 10:41
 */
public class PrintMaxN {
    public static void printMaxN(int n) {
        if (n <= 0) {
            return;
        }
        String[] nums = new String[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = "0";
        }
        printCore(n, nums);
    }

    private static void printCore(int n, String[] nums) {
        //如果没到最大值，则打印
        while (!reachMax(n, nums)) {
            myPrint(nums);
        }
    }

    //当前是否是最大值
    private static boolean reachMax(int n, String[] nums) {
        //通过加一后判断最高位是否有进位来判断
        boolean jinwei = false;
        for (int i = n - 1; i >= 0; i--) {
            int tmp = Integer.parseInt(nums[i]) + (jinwei ? 1 : 0) + (i == n - 1 ? 1 : 0);
            if (tmp > 9) {
                nums[i] = (tmp - 10) + "";
                jinwei = true;
            } else {
                nums[i] = tmp + "";
                jinwei = false;
            }
            if (i == 0 && jinwei) {
                return true;
            }
        }
        return false;
    }

    //打印出当前数字
    private static void myPrint(String[] nums) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for (; i < nums.length; i++) {
            if (!"0".equals(nums[i])) {
                break;
            }
        }
        for (; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printMaxN(30);
    }
}
