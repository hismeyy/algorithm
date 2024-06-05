// 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [2,7,11,15], target = 9
// 输出：[0,1]
// 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
// 
//
// 示例 2： 
//
// 
// 输入：nums = [3,2,4], target = 6
// 输出：[1,2]
// 
//
// 示例 3： 
//
// 
// 输入：nums = [3,3], target = 6
// 输出：[0,1]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 只会存在一个有效答案 
// 
//
// 
//
// 进阶：你可以想出一个时间复杂度小于 O(n²) 的算法吗？ 
//
// Related Topics 数组 哈希表 👍 18608 👎 0

package esay;

import java.util.HashMap;

//java:两数之和
class P1TwoSum {

    public static void main(String[] args) {
        Solution solution = new P1TwoSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    int sum = nums[i] + nums[j];
                    if (target == sum) {
                        return new int[]{i, j};
                    }
                }
            }
            return null;

        }
    }

    class SolutionAI {
        public int[] twoSum(int[] nums, int target) {
            // 1. 创建HashMap
            HashMap<Integer, Integer> map = new HashMap<>();

            // 2. 遍历nums
            for (int i = 0; i < nums.length; i++) {
                // 计算差值
                int diff = target - nums[i];

                // 判断差值是否存在于map中
                if (map.containsKey(diff)) {
                    // 存在 返回当前下表和插值的val
                    return new int[]{map.get(diff), i};
                }

                // 不存在把差值和下表存储map
                map.put(nums[i], i);
            }

            // 3. 找不到返回null
            return null;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

/**
 * 我的解答方式 算法复杂度时O(n²) 采用了嵌套for循环的方式
 * <p>
 * AI：O(n)
 * 1. 创建一个哈希表 map，用于存储数组中的值及其对应的下标。
 * 2. 遍历nums
 * - 计算目标值与当前元素的差值
 * - 检查差值是否已经存在于哈希表中
 * - 如果存在，返回当前元素下标和差值对应的下标
 * - 如果不存在，将当前元素及其下标添加到哈希表中
 * 3. 如果没有找到，返回null
 */