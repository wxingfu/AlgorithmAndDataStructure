package com.wxf.leetcode.sword_finger_offer;

import com.wxf.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 * <p>
 * 例如:
 * 给定二叉树:[3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 *
 * <p>
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof
 */
public class TreeLevelOrder3 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;

        node3.left = node4;
        node3.right = node5;

        List<List<Integer>> lists = levelOrder(node1);
        System.out.println(lists);

    }

    /**
     * 利用双端队列LinkedList实现存储顺序
     * <p>
     * 偶数层头插法
     * 奇数层尾插法
     *
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();

        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {

            LinkedList<Integer> linkedList = new LinkedList<>();

            for (int i = queue.size(); i > 0; i--) {

                TreeNode node = queue.poll();

                if (result.size() % 2 == 0) {
                    linkedList.addLast(node.value); // 偶数层 -> 队列头部
                } else {
                    linkedList.addFirst(node.value); // 奇数层 -> 队列尾部
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(linkedList);
        }
        return result;
    }
}
