//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 每个右括号都有一个对应的相同类型的左括号。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
//
// Related Topics 栈 字符串 👍 4456 👎 0

package esay;

import java.util.ArrayList;
import java.util.Stack;

//java:有效的括号
class P20ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new P20ValidParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {

            if (s.length() == 0 || s.length() == 1 || s.length() % 2 != 0){
                return false;
            }

            Stack<Character> characterStack = new Stack<Character>();
            int result = 0;
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){

                    characterStack.push(s.charAt(i));
                }else {
                    if(characterStack.size() == 0){
                        return false;
                    }else {
                        Character temp = characterStack.pop();
                        if(temp == '(' && s.charAt(i) == ')'){
                            result++;
                            continue;
                        }else if(temp == '{' && s.charAt(i) == '}'){
                            result++;
                            continue;
                        }else if(temp == '[' && s.charAt(i) == ']'){
                            result++;
                            continue;
                        }
                        characterStack.push(temp);
                    }
                }
            }
            if(result == s.length() / 2){
                return true;
            }else {
                return false;
            }
        }
    }

    class SolutionAI {
        public boolean isValid(String s) {
            if (s == null || s.length() == 0) {
                return true;
            }

            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    char top = stack.pop();
                    if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }

        // 用数组模拟栈
        public boolean isValidAI(String s) {
            if (s == null || s.length() == 0) {
                return true;
            }

            char[] stack = new char[s.length()];
            int top = -1;

            for (char c : s.toCharArray()) {
                if (c == '(' || c == '{' || c == '[') {
                    stack[++top] = c;
                } else {
                    if (top == -1) {
                        return false;
                    }
                    char topChar = stack[top--];
                    if ((c == ')' && topChar != '(') ||
                            (c == '}' && topChar != '{') ||
                            (c == ']' && topChar != '[')) {
                        return false;
                    }
                }
            }
            return top == -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}