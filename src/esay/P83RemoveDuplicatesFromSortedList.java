//给定一个已排序的链表的头
// head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,1,2]
//输出：[1,2]
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,1,2,3,3]
//输出：[1,2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序 排列 
// 
//
// Related Topics 链表 👍 1132 👎 0

package esay;

class ListNode {
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

//java:删除排序链表中的重复元素
class P83RemoveDuplicatesFromSortedList {


    public static void main(String[] args) {
        Solution solution = new P83RemoveDuplicatesFromSortedList().new Solution();
        ListNode listNode = new ListNode();
        ListNode listNode1 = new ListNode();
        ListNode listNode2 = new ListNode();
        listNode.val = 1;
        listNode1.val = 1;
        listNode2.val = 2;
        listNode.next = listNode1;
        listNode1.next = listNode2;
        solution.deleteDuplicates(listNode);
    }
    //leetcode submit region begin(Prohibit modification and deletion)


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
        public ListNode deleteDuplicates(ListNode head) {
            if (null == head) {
                return head;
            }

            ListNode result = new ListNode();
            ListNode resultP = result;
            ListNode tempP = head;
            int tempVal = -101;
            while (tempP != null) {
                int tempPval = tempP.val;
                if (-101 != tempVal && tempVal != tempPval) {
                    ListNode listNode = new ListNode(tempVal);
                    result.next = listNode;
                    result = result.next;
                }
                tempVal = tempPval;

                tempP = tempP.next;
            }

            ListNode listNode = new ListNode(tempVal);
            result.next = listNode;


            return resultP.next;

        }
    }

    class SolutionAI {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) {
                return head;
            }

            ListNode current = head;

            while (current != null && current.next != null) {
                if (current.val == current.next.val) {
                    // 跳过重复的节点
                    current.next = current.next.next;
                } else {
                    // 继续检查下一个节点
                    current = current.next;
                }
            }

            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}