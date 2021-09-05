package com.wxf.leetcode;


import com.wxf.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * 例如:
 * 给定二叉树:[3,9,20,null,null,15,7],
 * <p>
 *   3
 *  / \
 * 9  20
 *   /  \
 *  15   7
 * 返回：
 * <p>
 * [3,9,20,15,7]
 * <p>
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof
 */
public class TreeLevelOrder {

    public static void main(String[] args) {

    }

    /**
     * 二叉树的广度优先遍历，即层次遍历
     *
     * 利用队列的先进先出特点实现
     *
     * @param root
     * @return
     */
    public static int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode curr = null;
        while (!queue.isEmpty()) {
            curr = queue.poll();

            list.add(curr.val);

            if (curr.left != null) {
                queue.offer(curr.left);
            }
            if (curr.right != null) {
                queue.offer(curr.right);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
