//给定两个字符串 s 和 t ，判断它们是否是同构的。 
//
// 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。

//
// 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。 
//
// 
//
// 示例 1: 
//
// 
//输入：s = "egg", t = "add"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "foo", t = "bar"
//输出：false 
//
// 示例 3： 
//
// 
//输入：s = "paper", t = "title"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 
//
// 
// 1 <= s.length <= 5 * 10⁴ 
// t.length == s.length 
// s 和 t 由任意有效的 ASCII 字符组成 
// 
//
// Related Topics 哈希表 字符串 👍 721 👎 0

package esay;

import java.util.ArrayList;
import java.util.HashMap;

//java:同构字符串
class P205IsomorphicStrings {
    public static void main(String[] args) {
        Solution solution = new P205IsomorphicStrings().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isIsomorphic(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }

            HashMap<Character, Character> sToT = new HashMap<>();
            HashMap<Character, Character> tToS = new HashMap<>();

            for (int i = 0; i < s.length(); i++) {
                char c1 = s.charAt(i);
                char c2 = t.charAt(i);

                if (sToT.containsKey(c1)) {
                    if (sToT.get(c1) != c2) {
                        return false;
                    }
                } else {
                    sToT.put(c1, c2);
                }

                if (tToS.containsKey(c2)) {
                    if (tToS.get(c2) != c1) {
                        return false;
                    }
                } else {
                    tToS.put(c2, c1);
                }
            }

            return true;
        }
    }

    class SolutionAI {
        public boolean isIsomorphic(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }

            int[] sMap = new int[256];
            int[] tMap = new int[256];

            for (int i = 0; i < s.length(); i++) {
                char c1 = s.charAt(i);
                char c2 = t.charAt(i);

                // If the current characters' last seen positions are different
                if (sMap[c1] != tMap[c2]) {
                    return false;
                }

                // Update the last seen positions to the current index + 1
                // (to distinguish between default value 0 and the first position 0)
                sMap[c1] = i + 1;
                tMap[c2] = i + 1;
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

/**
 * 方式1：
 * 把两个字符串中的每个字母 通过Map映射起来
 * <p>
 * 方式2：
 * 把字母看成数组的索引，判断索引中的值是否一致
 */