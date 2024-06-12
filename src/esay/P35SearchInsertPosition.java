//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
//
// 请必须使用时间复杂度为 O(log n) 的算法。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,3,5,6], target = 5
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,3,5,6], target = 2
//输出: 1
// 
//
// 示例 3: 
//
// 
//输入: nums = [1,3,5,6], target = 7
//输出: 4
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 为 无重复元素 的 升序 排列数组 
// -10⁴ <= target <= 10⁴ 
//  z
//
// Related Topics 数组 二分查找 👍 2319 👎 0

package esay;

//java:搜索插入位置
class P35SearchInsertPosition {
    public static void main(String[] args) {
        Solution solution = new P35SearchInsertPosition().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int searchInsert(int[] nums, int target) {
            if (nums.length == 0) {
                return 0;
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] >= target) {
                    return i;
                }
            }
            return nums.length;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    class SolutionAI {
        public int searchInsert(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return left;
        }
    }

}

/**
 * 我的：时间复杂度O(n)
 * 二分查找
 * 思路：
 * 1. 初始化左右指针：初始化两个指针，left 指向数组的起始位置，right 指向数组的结束位置。
 * 2. 进入循环：当 left 小于等于 right 时，进行以下步骤。
 * 3. 计算中间位置：计算中间位置 mid。使用 mid = left + (right - left) / 2 来防止潜在的整数溢出。
 * 4. 比较中间值和目标值：
 * - 如果 nums[mid] == target，直接返回 mid。
 * - 如果 nums[mid] < target，说明目标值在右半部分，更新 left 为 mid + 1。
 * - 如果 nums[mid] > target，说明目标值在左半部分，更新 right 为 mid - 1。
 * 5. 返回插入位置：如果循环结束后没有找到目标值，left 的位置就是目标值应该插入的位置。
 */