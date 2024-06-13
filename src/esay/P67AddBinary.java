//给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。 
//
// 
//
// 示例 1： 
//
// 1 1 0
//输入:a = "11", b = "1"
//输出："100" 
//
// 示例 2： 
//
// 4 3 3 2 2 1 1 0 0
//输入：a = "1010", b = "1011"
//输出："10101" 
//
// 
//
// 提示： 
//
// 
// 1 <= a.length, b.length <= 10⁴ 
// a 和 b 仅由字符 '0' 或 '1' 组成 
// 字符串如果不是 "0" ，就不含前导零 
// 
//
// Related Topics 位运算 数学 字符串 模拟 👍 1205 👎 0

package esay;

//java:二进制求和
class P67AddBinary {
    public static void main(String[] args) {
        Solution solution = new P67AddBinary().new Solution();
        solution.addBinary("11", "1");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addBinary(String a, String b) {
            String result = "";
            int index = 0;
            int diffIndex = 0;
            if (a.length() <= b.length()) {
                index = b.length() - 1;
                diffIndex = b.length() - a.length();
            } else {
                index = a.length() - 1;
                diffIndex = a.length() - b.length();
            }

            int temp = 0;

            for (; index >= 0; index--) {
                int x, y = 0;
                if (a.length() <= b.length()) {
                    // a小
                    x = Character.getNumericValue(b.charAt(index));
                    if (index - diffIndex >= 0) {
                        y = Character.getNumericValue(a.charAt(index - diffIndex));
                    } else {
                        y = 0;
                    }

                } else {
                    // b小
                    x = Character.getNumericValue(a.charAt(index));
                    if (index - diffIndex >= 0) {
                        y = Character.getNumericValue(b.charAt(index - diffIndex));
                    } else {
                        y = 0;
                    }

                }

                int z = x + y + temp;
                if (z == 0 || z == 1) {
                    result = z + result;
                    temp = 0;
                } else if (z == 2) {
                    result = "0" + result;
                    temp = 1;
                } else if (z == 3) {
                    result = "1" + result;
                    temp = 1;
                }
            }

            if (temp != 0) {
                result = temp + result;
            }

            return result;

        }
    }

    class SolutionAI {
        public String addBinary(String a, String b) {
            int maxLength = Math.max(a.length(), b.length());

            // 将较短的字符串用前导零补齐
            a = String.format("%" + maxLength + "s", a).replace(' ', '0');
            b = String.format("%" + maxLength + "s", b).replace(' ', '0');

            StringBuilder result = new StringBuilder();
            int carry = 0;

            // 从两个字符串的最后一个字符开始相加
            for (int i = maxLength - 1; i >= 0; i--) {
                int x = Character.getNumericValue(a.charAt(i));
                int y = Character.getNumericValue(b.charAt(i));
                int sum = x + y + carry;

                // 计算当前位的值和进位
                result.append(sum % 2);
                carry = sum / 2;
            }

            // 如果最后还有进位，添加到结果中
            if (carry != 0) {
                result.append(carry);
            }

            // 当前结果是逆序的，需要反转
            return result.reverse().toString();
        }
    }

    class SolutionAI2 {
        public String addBinary(String a, String b) {
            int i = a.length() - 1;
            int j = b.length() - 1;
            int carry = 0;
            StringBuilder result = new StringBuilder();

            // 从两个字符串的末尾开始相加
            while (i >= 0 || j >= 0) {
                int sum = carry;
                if (i >= 0) {
                    sum += a.charAt(i) - '0';
                    i--;
                }
                if (j >= 0) {
                    sum += b.charAt(j) - '0';
                    j--;
                }
                result.append(sum % 2);  // 添加当前位
                carry = sum / 2;         // 计算进位
            }

            // 如果最后还有进位，添加到结果中
            if (carry != 0) {
                result.append(carry);
            }

            // 当前结果是逆序的，需要反转
            return result.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}