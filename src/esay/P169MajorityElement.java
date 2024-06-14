//给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,2,3]
//输出：3 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,1,1,1,2,2]
//输出：2
// 
//
// 
//提示：
//
// 
// n == nums.length 
// 1 <= n <= 5 * 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// 
//
// 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。 
//
// Related Topics 数组 哈希表 分治 计数 排序 👍 2215 👎 0

package esay;

import java.util.*;

//java:多数元素
class P169MajorityElement {
    public static void main(String[] args) {
        Solution solution = new P169MajorityElement().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {
            // 1. 先排序
            Arrays.sort(nums);
            // 2. 遍历 e 数量 存储到 map 中
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            int count = 1;
            int temp = -1;
            for (int i = 0; i < nums.length; i++) {
                if (temp != -1) {
                    if (temp == nums[i]) {
                        count++;
                    } else {
                        map.put(temp, count);
                        count = 1;
                    }
                }

                temp = nums[i];
                map.put(temp, count);
            }
            // 3. 遍历 map 找到 e 数量大于 n/2 的
            int max = -1;
            int maxValue = -1;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (maxValue < entry.getValue()) {
                    max = entry.getKey();
                    maxValue = entry.getValue();
                }
            }
            return max;

        }

        class SolutionAI {
            //  Boyer-Moore 投票算法 大为震撼
            public int majorityElement(int[] nums) {
                int count = 0;
                Integer candidate = null;

                for (int num : nums) {
                    if (count == 0) {
                        candidate = num;
                    }
                    count += (num == candidate) ? 1 : -1;
                }

                return candidate;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}