package com.wxf.leetcode.sword_finger_offer;

import com.wxf.common.TreeNode;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * <p>
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * <p>
 * 例如:
 * 给定的树 A:
 * <p>
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 * <p>
 *    4 
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 * <p>
 * 链接：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof
 */
public class IsSubStructure {

    public static void main(String[] args) {


    }

    /**
     * 递归遍历结构，左子树，右子树
     *
     * @param A
     * @param B
     * @return
     */
    public static boolean isSubStructure(TreeNode A, TreeNode B) {

        if (B == null || A == null) {
            return false;
        }
        if (A.value == B.value && (recurse(A.left, B.left) && recurse(A.right, B.right))) {
            return true;
        }
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public static boolean recurse(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }
        if (A.value == B.value) {
            return recurse(A.left, B.left) && recurse(A.right, B.right);
        } else {
            return false;
        }
    }
}
