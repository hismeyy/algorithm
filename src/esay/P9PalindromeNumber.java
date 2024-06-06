// 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
//
// 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。 
//
// 
// 例如，121 是回文，而 123 不是。 
// 
//
// 
//
// 示例 1： 
//
// 
// 输入：x = 121
// 输出：true
// 
//
// 示例 2： 
//
// 
// 输入：x = -121
// 输出：false
// 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3： 
//
// 
// 输入：x = 10
// 输出：false
// 解释：从右向左读, 为 01 。因此它不是一个回文数。
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
// 
//
// 进阶：你能不将整数转为字符串来解决这个问题吗？ 
//
// Related Topics 数学 👍 2851 👎 0

package esay;

//java:回文数
class P9PalindromeNumber {
    public static void main(String[] args) {
        Solution solution = new P9PalindromeNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(int x) {
            String s = String.valueOf(x);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                    return false;
                }
            }
            return true;
        }
    }

    class SolutionAI {
        public boolean isPalindrome(int x) {
            // 负数不可能是回文数
            if (x < 0) {
                return false;
            }

            // 个位数 就是回文数
            if (x < 10) {
                return true;
            }

            // 如果是0结尾并且不是0则不是回文数
            if (x % 10 == 0 && x != 0) {
                return false;
            }

            int revertedNumber = 0;
            while (x > revertedNumber) {
                revertedNumber = revertedNumber * 10 + x % 10;
                x = x / 10;
            }

            return x == revertedNumber || x == revertedNumber / 10;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

/**
 * My：转成字符串数组 s.charAt() 获取索引的字符
 * <p>
 * AI：计算数字 用数字比较大小
 */