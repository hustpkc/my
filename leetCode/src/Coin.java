/**
 * @author Pario
 * @description 硬币的组合情况数
 * @date 2020/4/23 14:36
 */
public class Coin {
    public static int waysToChange(int n) {

        int[] dp = new int[n + 1];

        int[] coins = new int[]{1, 5, 10, 25};


        //刚好可以用一个硬币凑成的情况，是一种情况
        // while i == coin :
        //dp[i] = dp[i - coin] => dp[0]
        dp[0] = 1;

        /**
         * dp方程：dp[i] += dp[i - coin];
         */

        for (int coin : coins) {
            for (int i = coin; i <= n; i++) {
                dp[i] = (dp[i] + dp[i - coin]) % 1000000007;
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int i = waysToChangeMy(5);
        System.out.println(i);
    }

    public static int waysToChangeMy(int n) {

        int[][] dp = new int[4][n + 1];

        int[] coins = new int[]{1, 5, 10, 25};


        /*dp[i][j]表示用前i个硬币组成总数j的方案的总数
        状态转移方程为dp[i][j]=dp[i-1][j]+dp[i-1][j-coins[i]]
         */

        for (int i = 0; i < 4; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j < n + 1; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < 4; i++) {
            for (int j = 1; j <= n; j++) {
                if (j - coins[i] >= 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[3][n];
    }
}
