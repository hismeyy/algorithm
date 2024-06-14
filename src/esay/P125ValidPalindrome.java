//如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。 
//
// 字母和数字都属于字母数字字符。 
//
// 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "A man, a plan, a canal: Panama"
//输出：true
//解释："amanaplanacanalpanama" 是回文串。
// 
//
// 示例 2： 
//
// 
//输入：s = "race a car"
//输出：false
//解释："raceacar" 不是回文串。
// 
//
// 示例 3： 
//
// 
//输入：s = " "
//输出：true
//解释：在移除非字母数字字符之后，s 是一个空字符串 "" 。
//由于空字符串正着反着读都一样，所以是回文串。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2 * 10⁵ 
// s 仅由可打印的 ASCII 字符组成 
// 
//
// Related Topics 双指针 字符串 👍 750 👎 0

package esay;

//java:验证回文串
class P125ValidPalindrome {
    public static void main(String[] args) {
        Solution solution = new P125ValidPalindrome().new Solution();
        solution.isPalindrome("A man, a plan, a canal: Panama");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            int left = 0;
            int right = s.length() - 1;

            while (left <= right) {
                char leftChar = s.charAt(left);
                char rightChar = s.charAt(right);

                // 检查左字符是否为字母或数字
                if (!Character.isLetterOrDigit(leftChar)) {
                    left++;
                    continue;
                }

                // 检查右字符是否为字母或数字
                if (!Character.isLetterOrDigit(rightChar)) {
                    right--;
                    continue;
                }

                // 转换为小写进行比较
                if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
                    return false;
                }

                left++;
                right--;
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

/**
 * Character.isLetterOrDigit() 检查字符是否为字母或数字
 * Character.toLowerCase() 将字符转换为小写
 * Character.toUpperCase() 将字符转换为大写
 * Character.isDigit() 检查字符是否为数字
 * Character.isLowerCase() 检查字符是否为小写字母
 * Character.isUpperCase() 检查字符是否为大写字母
 */