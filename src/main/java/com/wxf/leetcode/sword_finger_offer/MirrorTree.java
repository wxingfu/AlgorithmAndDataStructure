package com.wxf.leetcode.sword_finger_offer;

import com.wxf.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的镜像
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * <p>
 * 例如输入：
 * <p>
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 * <p>
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * <p>
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof
 */
public class MirrorTree {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(9);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        TreeNode treeNode = mirrorTree(node1);
        System.out.println(treeNode);

    }

    public static TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = mirrorTree(root.left);

        TreeNode right = mirrorTree(root.right);

        root.left = right;
        root.right = left;
        return root;
    }

    public static TreeNode mirrorTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            if (curr.left != null) {
                queue.offer(curr.left);
            }
            if (curr.right != null) {
                queue.offer(curr.right);
            }
            // 左右互换
            TreeNode node = curr.left;
            curr.left = curr.right;
            curr.right = node;
        }
        return root;
    }
}
