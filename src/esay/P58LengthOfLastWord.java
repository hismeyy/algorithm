//给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。 
//
// 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "Hello World"
//输出：5
//解释：最后一个单词是“World”，长度为 5。
// 
//
// 示例 2： 
//
// 
//输入：s = "   fly me   to   the moon  "
//输出：4
//解释：最后一个单词是“moon”，长度为 4。
// 
//
// 示例 3： 
//
// 
//输入：s = "luffy is still joyboy"
//输出：6
//解释：最后一个单词是长度为 6 的“joyboy”。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅有英文字母和空格 ' ' 组成 
// s 中至少存在一个单词 
// 
//
// Related Topics 字符串 👍 706 👎 0

package esay;

//java:最后一个单词的长度
class P58LengthOfLastWord {
    public static void main(String[] args) {
        Solution solution = new P58LengthOfLastWord().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLastWord(String s) {
            if (s.length() == 0) {
                return 0;
            }
            String str = s.trim();
            String[] strs = str.split(" ");
            String stringLast = strs[strs.length - 1];
            return stringLast.length();
        }
    }

    class Solution2 {
        public int lengthOfLastWord(String s) {
            int lastResult = 0;
            int result = 0;
            for (int index = 0; index < s.length(); index++) {
                if (s.charAt(index) == ' ') {
                    result = 0;
                } else {
                    result++;
                    lastResult = result;
                }
            }

            return lastResult;
        }
    }

    class SolutionAI {
        public int lengthOfLastWord(String s) {
            int length = s.length();
            int count = 0;

            // 从字符串末尾向前遍历，跳过尾部的所有空格
            int index = length - 1;
            while (index >= 0 && s.charAt(index) == ' ') {
                index--;
            }

            // 继续向前遍历，计算最后一个单词的长度
            while (index >= 0 && s.charAt(index) != ' ') {
                count++;
                index--;
            }

            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


/**
 * 方式1：
 * 去掉首位空格
 * 通过空格切割数组
 * 返回最后一个数组长度
 * <p>
 * 方式2：
 * 遍历字符串，遇到空格，则长度置0，否则长度加1，最后返回长度
 * <p>
 * 方法3：
 * 1. 先遍历后面的空格走到最后一个单词的后面
 * 2. 在数一下最后一个单词的长度
 */