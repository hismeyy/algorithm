//给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。 
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。 
//
// 
//
// 
//
// 示例 1: 
//
// 
//输入: rowIndex = 3
//输出: [1,3,3,1]
// 
//
// 示例 2: 
//
// 
//输入: rowIndex = 0
//输出: [1]
// 
//
// 示例 3: 
//
// 
//输入: rowIndex = 1
//输出: [1,1]
// 
//
// 
//
// 提示: 
//
// 
// 0 <= rowIndex <= 33 
// 
//
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(rowIndex) 空间复杂度吗？ 
//
// Related Topics 数组 动态规划 👍 545 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//java:杨辉三角 II
class P119PascalsTriangleIi {
    public static void main(String[] args) {
        Solution solution = new P119PascalsTriangleIi().new Solution();
        solution.getRow(3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> getRow(int rowIndex) {
            List<Integer> row = new ArrayList<>();
            long c = 1;
            row.add((int) c); // 第一个元素永远是1

            // i| / j| * (i - j)|
            for (int j = 1; j <= rowIndex; j++) {
                c = c * (rowIndex - j + 1) / j;
                row.add((int) c);
            }

            return row;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}