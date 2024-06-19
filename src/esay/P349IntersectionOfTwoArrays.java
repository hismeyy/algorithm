//给定两个数组 nums1 和 nums2 ，返回 它们的 交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4]
//解释：[4,9] 也是可通过的
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 1000 
// 
//
// Related Topics 数组 哈希表 双指针 二分查找 排序 👍 914 👎 0

package esay;

import java.util.HashSet;
import java.util.Set;

//java:两个数组的交集
class P349IntersectionOfTwoArrays {
    public static void main(String[] args) {
        Solution solution = new P349IntersectionOfTwoArrays().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> set1 = new HashSet<>();
            Set<Integer> resultSet = new HashSet<>();

            // 将 nums1 的元素添加到 set1 中
            for (int num : nums1) {
                set1.add(num);
            }

            // 检查 nums2 的元素是否在 set1 中
            for (int num : nums2) {
                if (set1.contains(num)) {
                    resultSet.add(num);
                }
            }

            // 将结果集合 resultSet 转换为数组
            int[] result = new int[resultSet.size()];
            int index = 0;
            for (int num : resultSet) {
                result[index++] = num;
            }

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}