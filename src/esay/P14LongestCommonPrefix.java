//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
//
// Related Topics 字典树 字符串 👍 3131 👎 0

package esay;

//java:最长公共前缀
class P14LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new P14LongestCommonPrefix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }

            // 以第一个字符串作为基准
            String prefix = strs[0];

            // 遍历剩余的字符串
            for (int i = 1; i < strs.length; i++) {
                // 不断地截取前缀，直到它是当前字符串的前缀
                while (strs[i].indexOf(prefix) != 0) {
                    // 截取前缀长度-1的子字符串
                    prefix = prefix.substring(0, prefix.length() - 1);
                    // 如果前缀为空，则没有公共前缀
                    if (prefix.isEmpty()) {
                        return "";
                    }
                }
            }

            return prefix;
        }
    }

    class SolutionAI {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }

            for (int i = 0; i < strs[0].length(); i++) {
                char c = strs[0].charAt(i);
                for (int j = 1; j < strs.length; j++) {
                    // 检查当前字符是否越界或者不同
                    if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                        return strs[0].substring(0, i);
                    }
                }
            }
            return strs[0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

/**
 * s.indexOf(x) 可以检测出x首次出现在s的索引位置
 * substring() 切割字符串
 */