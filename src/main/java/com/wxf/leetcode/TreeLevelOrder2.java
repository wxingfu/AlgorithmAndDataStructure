package com.wxf.leetcode;

import com.wxf.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 *
 * 例如:
 * 给定二叉树:[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof
 */
public class TreeLevelOrder2 {

    public static void main(String[] args) {

    }

    /**
     * 二叉树层次遍历，打印时机
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> lists = new ArrayList<>();
        if(root != null) {
            queue.offer(root);
        }
        TreeNode node = null;
        while(!queue.isEmpty()) {
            List<Integer> tempList = new ArrayList<>();
            for(int i = queue.size(); i > 0; i--) {
                node = queue.poll();
                tempList.add(node.val);
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            lists.add(tempList);
        }
        return lists;
    }
}
