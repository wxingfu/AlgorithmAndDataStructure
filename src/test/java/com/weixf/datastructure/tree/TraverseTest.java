package com.weixf.datastructure.tree;

import com.weixf.node.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class TraverseTest {

    @Test
    public void test() {
        TreeNode root = new TreeNode(0);
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        TreeNode root6 = new TreeNode(6);
        TreeNode root7 = new TreeNode(7);
        TreeNode root8 = new TreeNode(8);

        root.left = root1;
        root.right = root2;

        root1.left = root3;
        root1.right = root4;

        root2.left = root5;
        root2.right = root6;

        root3.left = root7;
        root3.right = root8;

        // traverse(root, 1);
        //
        // count(root);

        System.out.println(maxDepth(root));
        System.out.println(diameterOfBinaryTree(root));

        // levelTraverse(root);
    }


    public void traverse(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        System.out.printf("节点 %s 在第 %d 层 \n", root.val, level);
        traverse(root.left, level + 1);
        traverse(root.right, level + 1);
    }


    int count(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftCount = count(root.left);
        int rightCount = count(root.right);

        System.out.printf("节点 %s 的左子树有 %d 个节点，右子树有 %d 个节点 \n", root.val, leftCount, rightCount);

        return leftCount + rightCount + 1;
    }

    int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);

        int tmpDiameter = leftMax + rightMax;
        maxDiameter = Math.max(maxDiameter, tmpDiameter);

        return Math.max(leftMax, rightMax) + 1;
    }

    int maxDiameter = 0;

    int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }

    void levelTraverse(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode curr = q.poll();
                if (curr != null) {
                    System.out.print(curr.val + " ");
                    if (curr.left != null) {
                        q.offer(curr.left);
                    }
                    if (curr.right != null) {
                        q.offer(curr.right);
                    }
                }
            }
            System.out.println();
        }


    }


    @Test
    public void test1() {
        // TreeNode root = new TreeNode(3);
        // TreeNode root1 = new TreeNode(9);
        // TreeNode root2 = new TreeNode(20);
        // TreeNode root3 = new TreeNode(15);
        // TreeNode root4 = new TreeNode(7);
        //
        // root.left = root1;
        // root.right = root2;
        //
        // root2.left = root3;
        // root2.right = root4;


        // TreeNode root = new TreeNode(2);
        // TreeNode root1 = new TreeNode(3);
        // TreeNode root2 = new TreeNode(4);
        // TreeNode root3 = new TreeNode(5);
        // TreeNode root4 = new TreeNode(6);
        //
        // root.right = root1;
        // root1.right = root2;
        // root2.right = root3;
        // root3.right = root4;


        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        TreeNode root6 = new TreeNode(6);
        TreeNode root7 = new TreeNode(7);

        root1.left = root2;
        root1.right = root3;

        root2.left = root4;
        root2.right = root5;

        root5.left = root6;
        root5.right = root7;

        int minDepth = minDepth(root1);
        System.out.println(minDepth);

    }

    int minDepth(TreeNode root) {
        int depth = 0;
        if (root == null) {
            return depth;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        depth += 1;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode curr = q.poll();
                if (curr != null) {
                    if (curr.left == null && curr.right == null) {
                        return depth;
                    }
                    if (curr.left != null) {
                        q.offer(curr.left);
                    }
                    if (curr.right != null) {
                        q.offer(curr.right);
                    }
                }
            }
            depth += 1;
        }
        return depth;
    }

}
