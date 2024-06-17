//给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。 
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
//输入: numRows = 5
//输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// 
//
// 示例 2: 
//
// 
//输入: numRows = 1
//输出: [[1]]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= numRows <= 30 
// 
//
// Related Topics 数组 动态规划 👍 1166 👎 0

package esay;

import java.util.ArrayList;
import java.util.List;

//java:杨辉三角
class P118PascalsTriangle {
    public static void main(String[] args) {
        Solution solution = new P118PascalsTriangle().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> resultList = new ArrayList<List<Integer>>();
            for (int i = 0; i < numRows; i++) {
                List<Integer> temp = new ArrayList<Integer>();

                for (int j = 0; j <= i; j++) {
                    if (j == 0 || j == i) {
                        temp.add(1);
                    } else {
                        List<Integer> up = resultList.get(i - 1);
                        Integer num = up.get(j) + up.get(j - 1);
                        temp.add(num);
                    }
                }

                resultList.add(temp);
            }

            return resultList;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}