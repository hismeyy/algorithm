//稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。 
//
// 示例1: 
//
//  输入: words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""],
// s = "ta"
// 输出：-1
// 说明: 不存在返回-1。
// 
//
// 示例2: 
//
//  输入：words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], 
//s = "ball"
// 输出：4
// 
//
// 提示: 
//
// 
// words的长度在[1, 1000000]之间 
// 
//
// Related Topics 数组 字符串 二分查找 👍 86 👎 0

package esay;

import java.util.HashMap;//java:稀疏数组搜索

class P1005SparseArraySearchLcci {
    public static void main(String[] args) {
        Solution solution = new P1005SparseArraySearchLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findString(String[] words, String s) {
            HashMap<String, Integer> map = new HashMap<String, Integer>();
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals("")) {
                    continue;
                }
                map.put(words[i], i);
            }
            return map.getOrDefault(s, -1);
        }
    }

    class SolutionAI {
        public int findString(String[] words, String s) {
            int left = 0, right = words.length - 1;

            while (left <= right) {
                // Skip any empty strings
                while (left <= right && words[left].equals("")) {
                    left++;
                }
                while (left <= right && words[right].equals("")) {
                    right--;
                }

                int mid = left + (right - left) / 2;

                // Move mid to the closest non-empty string
                while (mid <= right && words[mid].equals("")) {
                    mid++;
                }

                if (mid > right) {
                    break; // No non-empty string found in the range
                }

                int comp = s.compareTo(words[mid]);
                if (comp == 0) {
                    return mid;
                } else if (comp < 0) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}