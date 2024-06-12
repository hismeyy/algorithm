//给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = [1,2,3]
//输出：[1,2,4]
//解释：输入数组表示数字 123。
// 
//
// 示例 2： 
//
// 
//输入：digits = [4,3,2,1]
//输出：[4,3,2,2]
//解释：输入数组表示数字 4321。
// 
//
// 示例 3： 
//
// 
//输入：digits = [0]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= digits.length <= 100 
// 0 <= digits[i] <= 9 
// 
//
// Related Topics 数组 数学 👍 1396 👎 0

package esay;

//java:加一
class P66PlusOne {
    public static void main(String[] args) {
        Solution solution = new P66PlusOne().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] plusOne(int[] digits) {
            for (int i = digits.length - 1; i >= 0; i--) {
                int temp = digits[i] + 1;
                if (temp > 9) {
                    digits[i] = 0;
                } else {
                    digits[i] = temp;
                    break;
                }
            }

            if (digits[0] == 0) {
                int[] temp = new int[digits.length + 1];
                temp[0] = 1;
                for (int i = 1; i < temp.length; i++) {
                    temp[i] = digits[i - 1];
                }
                return temp;
            }
            return digits;
        }
    }

    class SolutionAI1 {
        public int[] plusOne(int[] digits) {
            for (int i = digits.length - 1; i >= 0; i--) {
                digits[i]++;
                if (digits[i] > 9) {
                    digits[i] = 0;
                } else {
                    return digits;
                }
            }

            // 如果所有的位都是9，例如[9, 9, 9]，则需要多一位来存储进位
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            System.arraycopy(digits, 0, result, 1, digits.length);
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}