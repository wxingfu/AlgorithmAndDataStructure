package com.wxf.interview;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 数组二叉树
 * <p>
 * 根据数组构建二叉树，并且遍历输出
 */
public class ArrayTree {

    public static void main(String[] args) {


    }

    public static TreeNode constructTree(Integer[] nums) {

        if (nums == null || nums.length == 0 || nums[0] == null) {
            return null;
        }

        int index = 0;
        int length = nums.length;

        TreeNode root = new TreeNode(nums[0]);
        // 定义一个队列存储节点
        Deque<TreeNode> nodeQueue = new LinkedList<>();
        // 将root节点添加到头节点
        nodeQueue.offer(root);
        TreeNode currNode;
        while (!nodeQueue.isEmpty()) {
            // 获取并移除队列的头节点
            currNode = nodeQueue.poll();

            index++;
            if (index >= length) {
                return root;
            }
            if (nums[index] != null) {
                // 左子树赋值
                currNode.left = new TreeNode(nums[index]);
                // 将左子树的节点添加至队列尾部
                nodeQueue.offer(currNode.left);
            }

            index++;
            if (index >= length) {
                return root;
            }
            if (nums[index] != null) {
                // 右子树赋值
                currNode.right = new TreeNode(nums[index]);
                // 将右子树添加至队列的尾部
                nodeQueue.offer(currNode.right);
            }
        }
        return root;
    }

}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }
}