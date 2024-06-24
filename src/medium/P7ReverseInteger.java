//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−2³¹, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= x <= 2³¹ - 1 
// 
//
// Related Topics 数学 👍 3998 👎 0

package medium;

//java:整数反转
class P7ReverseInteger {
    public static void main(String[] args) {
        Solution solution = new P7ReverseInteger().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reverse(int x) {
            int res = 0;
            while (x != 0) {
                int temp = x % 10;
                x = x / 10;

                // 检查是否会溢出
                if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && temp > 7)) {
                    return 0;
                }
                if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && temp < -8)) {
                    return 0;
                }

                res = res * 10 + temp;
            }
            return res;
        }
    }

    class SolutionAI {
        public int reverse(int x) {
            long result = 0;

            while (x != 0) {
                result = result * 10 + x % 10;
                x /= 10;
            }

            if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
                return 0;
            }

            return (int) result;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}