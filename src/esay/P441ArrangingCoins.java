//你总共有 n 枚硬币，并计划将它们按阶梯状排列。对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。阶梯的最后一行 可能 是不完整的。 
//
// 给你一个数字 n ，计算并返回可形成 完整阶梯行 的总行数。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 5
// 1
// 2 3
// 4 5 6
// 7 8 9 10
// 11 12 13 14 15
//输出：2
//解释：因为第三行不完整，所以返回 2 。
// 
//
// 示例 2： 
// 
// 
//输入：n = 8
//输出：3
//解释：因为第四行不完整，所以返回 3 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2³¹ - 1 
// 
//
// Related Topics 数学 二分查找 👍 299 👎 0

package esay;

//java:排列硬币
class P441ArrangingCoins {
    public static void main(String[] args) {
        Solution solution = new P441ArrangingCoins().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int arrangeCoins(int n) {
            long sum = 0;
            for (long i = 1; i <= n; i++) {
                sum += i;
                if (sum > n) {
                    return (int) (i - 1L);
                } else if (sum == n) {
                    return (int) i;
                }
            }
            return 0;
        }
    }

    class SolutionAI {
        public int arrangeCoins(int n) {
            long left = 0, right = n;
            while (left <= right) {
                long mid = left + (right - left) / 2;
                long total = mid * (mid + 1) / 2;
                if (total == n) {
                    return (int) mid;
                } else if (total < n) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return (int) right;
        }
    }

    class SolutionAI1 {
        public int arrangeCoins(int n) {
            // 使用数学公式直接计算
            return (int) ((Math.sqrt(1 + 8.0 * n) - 1) / 2);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}