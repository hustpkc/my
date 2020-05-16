import java.util.Arrays;

/**
 * @author Pario
 * @description
 * @date 2020/4/24 11:31
 */
public class InverseOrderPairCount {

    /**
     * 给定一个数组，计算包含的逆序对的总数，eg：{7,5,6,4}，输出5，有[7,5],[7,6],[7,4],[5,4],[6,4]
     *
     * @param a
     * @return
     */
    public static int numOfInversePair(int[] a) {
        if (a == null || a.length <= 0) {
            return 0;
        }
        return help(a, 0, a.length - 1);
    }

    private static int help(int[] a, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + (r - l) / 2;
        int temp[] = new int[a.length];
        int t = r;

        int left = help(a, l, mid);
        int right = help(a, mid + 1, r);
        int count = 0;
        int m = mid;
        int n = r;
        while (m >= l && n >= mid + 1) {
            if (a[m] <= a[n]) {
                temp[t--] = a[n--];
            } else {
                temp[t--] = a[m--];
                count += n - mid;
            }
        }
        while (m >= l) {
            temp[t--] = a[m--];
        }
        while (n >= mid + 1) {
            temp[t--] = a[n--];
        }
        for (int i = l; i <= r; i++) {
            a[i] = temp[i];
        }
        return left + right + count;

    }

    public static void main(String[] args) {
        System.out.println(numOfInversePair(new int[]{7, 5, 6, 4}));
    }

//    static class MergeSort {
//        public static void mergeSort(int[] a) {
//            if (a == null || a.length < 2) {
//                return;
//            }
//            sort(a, 0, a.length - 1);
//        }
//
//        private static void sort(int[] a, int start, int end) {
//            if (start == end) {
//                return;
//            }
//            int mid = start + (end - start) / 2;
//            sort(a, start, mid);
//            sort(a, mid + 1, end);
//            merge(a, start, mid, end);
//        }
//
//        public static void merge(int[] a, int start, int mid, int end) {
//            int[] temp = new int[a.length];
//            int t = 0;
//            while (t < temp.length) {
//                temp[t] = a[t];
//                t++;
//            }
//            t = start;
//            int i = start;
//            int j = mid + 1;
//            while (i <= mid && j <= end) {
//                if (temp[i] < temp[j]) {
//                    a[t++] = temp[i++];
//                } else {
//                    a[t++] = temp[j++];
//                }
//            }
//            while (i <= mid) {
//                a[t++] = temp[i++];
//            }
//            while (j <= end) {
//                a[t++] = temp[j++];
//            }
//        }
//
//        public static void main(String[] args) {
//            int[] a = {9, 8};
//            int[] b = {7, 8};
//            int[] c = {5, 6, 7, 8};
//            mergeSort(a);
//            merge(c, 0, 1, 3);
//            System.out.println(Arrays.toString(a));
//            System.out.println(Arrays.toString(c));
//
//            int d = 5;
//            while (d < 6) {
//            }
//        }
//    }

}
