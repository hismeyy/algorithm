//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
// 
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
//
// Related Topics 递归 链表 数学 👍 10645 👎 0

package medium;

//java:两数相加
class P2AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new P2AddTwoNumbers().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode head = new ListNode();
            ListNode cur = head;
            ListNode p1 = l1;
            ListNode p2 = l2;

            int val1 = 0;
            int val2 = 0;

            int temp = 0;
            while (p1 != null || p2 != null) {

                if (p1 != null) {
                    val1 = p1.val;
                    p1 = p1.next;
                } else {
                    val1 = 0;
                }

                if (p2 != null) {
                    val2 = p2.val;
                    p2 = p2.next;
                } else {
                    val2 = 0;
                }

                int sum = val1 + val2 + temp;
                temp = 0;
                if (sum >= 10) {
                    sum = sum - 10;
                    temp = 1;
                }

                ListNode tempNode = new ListNode(sum);
                cur.next = tempNode;
                cur = cur.next;

            }

            if (temp != 0) {
                ListNode tempNode = new ListNode(temp);
                cur.next = tempNode;
                cur = cur.next;
            }

            return head.next;
        }
    }


    class SolutionAI {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummyHead = new ListNode(0); // 虚拟头结点
            ListNode cur = dummyHead;
            int carry = 0;

            while (l1 != null || l2 != null) {
                int val1 = (l1 != null) ? l1.val : 0;
                int val2 = (l2 != null) ? l2.val : 0;

                int sum = val1 + val2 + carry;
                carry = sum / 10;
                cur.next = new ListNode(sum % 10);
                cur = cur.next;

                if (l1 != null) l1 = l1.next;
                if (l2 != null) l2 = l2.next;
            }

            if (carry > 0) {
                cur.next = new ListNode(carry);
            }

            return dummyHead.next;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}