//给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。 
//
// 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层
//为第 h 层，则该层包含 1~ 2ʰ 个节点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3,4,5,6]
//输出：6
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目范围是[0, 5 * 10⁴] 
// 0 <= Node.val <= 5 * 10⁴ 
// 题目数据保证输入的树是 完全二叉树 
// 
//
// 
//
// 进阶：遍历树来统计节点是一种时间复杂度为 O(n) 的简单解决方案。你可以设计一个更快的算法吗？ 
//
// Related Topics 位运算 树 二分查找 二叉树 👍 1142 👎 0

package esay;

import java.util.LinkedList;
import java.util.Queue;

//java:完全二叉树的节点个数
class P222CountCompleteTreeNodes {
    public static void main(String[] args) {
        Solution solution = new P222CountCompleteTreeNodes().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public int countNodes(TreeNode root) {
            if (root == null) {
                return 0;
            }
            // 初始化队列，加入根节点
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            // 初始化一个列表，用于保存遍历序列
            int i = 0;
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll(); // 队列出队
                i++;
                if (null != node.left)
                    queue.offer(node.left);   // 左子节点入队
                if (null != node.right)
                    queue.offer(node.right);  // 右子节点入队
            }
            return i;
        }
    }

    class SolutionAI {
        public int countNodes(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int leftDepth = getDepth(root.left);
            int rightDepth = getDepth(root.right);

            if (leftDepth == rightDepth) {
                // 左子树是满的，节点数为 2^leftDepth - 1，根节点+右子树节点数
                return (1 << leftDepth) + countNodes(root.right);
            } else {
                // 右子树是满的，节点数为 2^rightDepth - 1，根节点+左子树节点数
                return (1 << rightDepth) + countNodes(root.left);
            }
        }

        private int getDepth(TreeNode node) {
            int depth = 0;
            while (node != null) {
                depth++;
                node = node.left;
            }
            return depth;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}