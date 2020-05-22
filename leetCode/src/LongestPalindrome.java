/**
 * @author Pario
 * @description
 * @date 2020/5/18 9:35
 */
public class LongestPalindrome {
    String longestPalindrome(String s) {
        if ("".equals(s)) {
            return "";
        }

        int len = s.length();
        if (len == 1) {
            return s;
        }
        int longest = 1;//最长回文子串的长度
        int start = 0;//回文子串的起始位置
        //dp[i][j]表示从i到j的字符串是回文字符串
        int[][] dp = new int[len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
            if (i < len - 1) {//除了避免数组越界，没有什么卵用
                if (s.charAt(i) == s.charAt(i + 1)) {
                    dp[i][i + 1] = 1;
                    start = i;
                    longest = 2;
                }
            }
        }
        for (int l = 3; l <= len; l++)//子串长度
        {
            for (int i = 0; i + l - 1 < len; i++)//枚举子串的起始点
            {
                int j = l + i - 1;//终点
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == 1) {
                    dp[i][j] = 1;
                    start = i;
                    longest = l;
                }
            }
        }
        return s.substring(start, longest);
    }


    //马拉车算法
    String preProcess(String s) {
        int n = s.length();
        if (n == 0) return "^$";

        String ret = "^";
        for (int i = 0; i < n; i++) {
            ret += "#" + s.substring(i, i + 1);
        }

        ret += "#$";
        return ret;
    }

    public String longestPalindrome1(String s) {
        String T = preProcess(s);
        int length = T.length();
        int[] p = new int[length];
        int C = 0, R = 0;

        for (int i = 1; i < length - 1; i++) {
            int i_mirror = C - (i - C);
            int diff = R - i;
            if (diff >= 0)//当前i在C和R之间，可以利用回文的对称属性
            {
                if (p[i_mirror] < diff)//i的对称点的回文长度在C的大回文范围内部
                {
                    p[i] = p[i_mirror];
                } else {
                    p[i] = diff;
                    //i处的回文可能超出C的大回文范围了
                    while (T.charAt(i + p[i] + 1) == T.charAt(i - p[i] - 1)) {
                        p[i]++;
                    }
                    C = i;
                    R = i + p[i];
                }
            } else {
                p[i] = 0;
                while (T.charAt(i + p[i] + 1) == T.charAt(i - p[i] - 1)) {
                    p[i]++;
                }
                C = i;
                R = i + p[i];
            }
        }

        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < length - 1; i++) {
            if (p[i] > maxLen) {
                maxLen = p[i];
                centerIndex = i;
            }
        }
        return s.substring((centerIndex - 1 - maxLen) / 2, (centerIndex - 1 - maxLen) / 2 + maxLen);
    }
}

