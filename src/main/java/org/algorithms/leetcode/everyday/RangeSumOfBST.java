package org.algorithms.leetcode.everyday;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @class: RangeSumOfBST
 * @author: Lance Mone
 * @date: 2021/4/27 11:18
 * @description: 二叉搜索树的范围和
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和
 */

public class RangeSumOfBST {

    int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        return solutionByMyself(root, low, high);
    }

    int solutionByMyself(TreeNode root, int low, int high) {
        if(root == null) {
            return 0;
        }
        solutionByMyself(root.left, low, high);
        if(root.val >= low && root.val <= high) {
            System.out.println("root.val: " + root.val);
            sum += root.val;
            System.out.println("sum: " + sum);
        }
        solutionByMyself(root.right, low, high);
        return sum;
    }

    /**
     * 按深度优先搜索的顺序计算范围和
     * 记当前子树根节点为 root，分以下四种情况讨论：
     *root 节点为空,返回 0。
     *root 节点的值大于 high。由于二叉搜索树右子树上所有节点的值均大于根节点的值，即均大于 high，故无需考虑右子树，返回左子树的范围和。
     *root节点的值小于low，由于二叉搜索树左子树上所有节点的值均小于根节点的值，即均小于 low，故无需考虑左子树，返回右子树的范围和。
     *root 节点的值在 [low,high] 范围内,此时应返回 root 节点的值、左子树的范围和、右子树的范围和这三者之和。
     *
     * 复杂度分析
     * 时间复杂度：O(n)O(n)，其中 nn 是二叉搜索树的节点数。
     * 空间复杂度：O(n)O(n)。空间复杂度主要取决于栈空间的开销。
     * */
    int solutionByLeetcode1(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }

    /**
     * 广度优先搜索
     * 使用广度优先搜索的方法，用一个队列 q存储需要计算的节点。每次取出队首节点时，若节点为空则跳过该节点，
     * 否则按方法一中给出的大小关系来决定加入队列的子节点。
     * */
    int solutionByLeetcode2(TreeNode root, int low, int high) {
        int sum = 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                continue;
            }
            if (node.val > high) {
                q.offer(node.left);
            } else if (node.val < low) {
                q.offer(node.right);
            } else {
                sum += node.val;
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        return sum;
    }
}
