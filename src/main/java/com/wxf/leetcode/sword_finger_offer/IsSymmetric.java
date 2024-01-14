package com.wxf.leetcode.sword_finger_offer;

import com.wxf.common.TreeNode;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * <p>
 *  
 * <p>
 * 链接：https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof
 */
public class IsSymmetric {

    public static void main(String[] args) {

    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            // 空树
            return true;
        } else {
            return recurse(root.left, root.right);
        }
    }

    public static boolean recurse(TreeNode A, TreeNode B) {
        // 结束条件1：如果对称两个节点都为空，则返回true
        if (A == null && B == null) {
            return true;
        }
        // 结束条件2：如果单独一个节点为空，另一个节点不为空，又或者是对称节点间的val值不等，则返回false
        if (A == null || B == null || A.value != B.value) {
            return false;
        }
        // 该层符合对称二叉树的要求，开始比较下一层
        return recurse(A.left, B.right) && recurse(A.right, B.left);
    }
}
