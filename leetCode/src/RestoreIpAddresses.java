import java.util.ArrayList;
import java.util.List;

/**
 * @author Pario
 * @description
 * @date 2020/4/21 16:05
 */
public class RestoreIpAddresses {
    //java 回溯，限制条件好多 要慢慢想 很烦。 击败98% 还行
    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() < 4) return new ArrayList<>();

        List<String> result = new ArrayList<>();
        restoreIpAddresses(s, 0, new ArrayList<>(), result);
        return result;
    }

    /**
     * @param s      原字符串
     * @param index  已匹配到的位置
     * @param list   已匹配的分段列表 eg:125.567表示已匹配出两段
     * @param result
     */
    public void restoreIpAddresses(String s, int index, List<String> list, List<String> result) {
        // 预期结果能有的最大长度 最多能有4格，每个3位。 list是已占有的格数
        int maxLength = (4 - list.size()) * 3;
        // 如果原字符串剩余字符 大于预期最大长度 不符合要求
        if (s.length() - index > maxLength) {
            return;
        }
        // 满足条件
        if (list.size() == 4 && s.length() == index) {
            // 拼接处结果
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                if (i == 0)
                    sb.append(list.get(i));
                else
                    sb.append(".").append(list.get(i));
            }
            result.add(sb.toString());
        }
        for (int i = index + 1; i <= index + 3 && i <= s.length(); i++) {
            String ip = s.substring(index, i);
            // 大于255 不符合ip规则
            if (Integer.parseInt(ip) > 255) {
                continue;
            }
            // 大于1位数时 0不能为头
            if (ip.length() > 1 && "0".equals(ip.substring(0, 1))) {
                continue;
            }
            list.add(ip);
            restoreIpAddresses(s, i, list, result);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        RestoreIpAddresses a = new RestoreIpAddresses();
        List<String> strings = a.restoreIpAddressess("155869125");
        for (String string : strings) {
            System.out.println(string);
        }
    }

    public List<String> restoreIpAddressess(String s) {
        List<String> ans = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return ans;
        }
        // 回溯
        back(s, 0, new ArrayList<>(), ans);
        return ans;
    }

    // 中间两个参数解释：pos-当前遍历到 s 字符串中的位置，cur-当前存放已经确定好的 ip 段的数量
    private void back(String s, int pos, List<String> cur, List<String> ans) {
        if (cur.size() == 4) {
            // 如果此时 pos 也刚好遍历完整个 s
            if (pos == s.length()) {
                // join 用法：例如 [[255],[255],[111],[35]] -> 255.255.111.35
                ans.add(String.join(".", cur));
            }
            return;
        }

        // ip 地址每段最多有三个数字
        for (int i = 1; i <= 3; i++) {
            // 如果当前位置距离 s 末尾小于 3 就不用再分段了，直接跳出循环即可。
            if (pos + i > s.length()) {
                break;
            }
            // 将 s 的子串开始分段
            String segment = s.substring(pos, pos + i);
            // 剪枝条件：段的起始位置不能为 0，段拆箱成 int 类型的长度不能大于 255
            if (segment.startsWith("0") && segment.length() > 1 || (i == 3 && Integer.parseInt(segment) > 255)) {
                continue;
            }
            // 符合要求就加入到 cur 数组中
            cur.add(segment);
//            System.out.println(cur.toString());
            // 继续递归遍历下一个位置
            back(s, pos + i, cur, ans);
            // 回退到上一个元素，即回溯
            cur.remove(cur.size() - 1);
        }
    }
}
