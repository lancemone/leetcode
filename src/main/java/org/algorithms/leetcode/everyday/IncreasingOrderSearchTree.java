package org.algorithms.leetcode.everyday;


import java.util.ArrayList;
import java.util.List;

/**
 * @class: IncreasingOrderSearchTree
 * @author: Lance Mone
 * @date: 2021/4/25 16:33
 * @description: 递增顺序搜索树
 * 给你一棵二叉搜索树，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 * 例1：
 * 输入：root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 *
 * 例2：
 * 输入：root = [5,1,7]
 * 输出：[1,null,5,null,7]
 *
 * 提示：
 * 树中节点数的取值范围是 [1, 100]
 * 0 <= Node.val <= 1000
 */

// [5,3,6,2,4,null,8,1,null,null,null,7,9]
// [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

public class IncreasingOrderSearchTree {

    // 递归
    static TreeNode increasingBST2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inOrderTraverse(root, res);
        TreeNode treeNode = new TreeNode(-1);
        TreeNode curNode = treeNode;
        for (int value : res) {
            curNode.right = new TreeNode(value);
            curNode = curNode.right;
        }
        return treeNode.right;
    }

    // 中序遍历
    static void inOrderTraverse(TreeNode treeNode, List<Integer> res) {
        if (treeNode == null) {
            return;
        }
        inOrderTraverse(treeNode.left, res);
        res.add(treeNode.val);
        System.out.println(res);
        inOrderTraverse(treeNode.right, res);
    }

    TreeNode resNode;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummyNode = new TreeNode(-1);
        resNode = dummyNode;
        inorder(root);
        return dummyNode.right;
    }

    public void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println("node.val before inorder(node.left): " + node.val);
        if(node.right == null) {
            System.out.println("node.right before inorder(node.left): null");
        }else {
            System.out.println("node.right.val before inorder(node.left): " + node.right.val);
        }
        if(node.left == null) {
            System.out.println("node.left before inorder(node.left): null");
        }else {
            System.out.println("node.left.val before inorder(node.left): " + node.left.val);
        }
        inorder(node.left);
        System.out.println("node.val after inorder(node.left): " + node.val);
        if(node.left == null) {
            System.out.println("node.left after inorder(node.left): null");
        }else {
            System.out.println("node.left.val after inorder(node.left): " + node.left.val);
        }

        // 在中序遍历的过程中修改节点指向
        if(resNode.right == null) {
            System.out.println("resNode.right.val before resNode.right = node: null");
        }else {
            System.out.println("resNode.right.val before resNode.right = node: " + resNode.right.val);
        }
        resNode.right = node;
        if(resNode.right == null) {
            System.out.println("resNode.right.val after resNode.right = node: null");
        }else {
            System.out.println("resNode.right.val after resNode.right = node: " + resNode.right.val);
        }
        node.left = null;
        System.out.println("resNode.val before resNode = node;: " + resNode.val);
        resNode = node;
        System.out.println("resNode.val after resNode = node;: " + resNode.val);

        inorder(node.right);
    }
}

/**
 * Definition for a binary tree node.
 */

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
