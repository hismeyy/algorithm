//给你一个非负整数 x ，计算并返回 x 的 算术平方根 。 
//
// 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。 
//
// 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 4
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：x = 8
//输出：2
//解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= x <= 2³¹ - 1 
// 
//
// Related Topics 数学 二分查找 👍 1551 👎 0

package esay;

//java:x 的平方根
class P69Sqrtx {
    public static void main(String[] args) {
        Solution solution = new P69Sqrtx().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mySqrt(int x) {
            if (x < 2) {
                return x;
            }
            int left = 2;
            int right = x / 2;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                long num = (long) mid * mid;
                if (num == x) {
                    return mid;
                } else if (num > x) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return right;
        }
    }

    class SolutionAI {
        public int mySqrt(int x) {
            if (x < 2) {
                return x;
            }
            long guess = x;
            while (guess * guess > x) {
                guess = (guess + x / guess) / 2;
            }
            return (int) guess;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

/**
 * AI：用牛顿迭代法
 * <p>
 * 牛顿迭代法的公式为：
 * \[ x_{k+1} = \frac{x_k + \frac{n}{x_k}}{2} \]
 * 其中，\( x_k \) 是当前的猜测值，\( n \) 是我们要计算平方根的数。我们不断地更新 \( x_k \) 直到 \( x_k \) 收敛到我们需要的精度。
 */