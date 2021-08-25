package com.wxf.datastructure.tree;

/**
 * @author wxf
 * @date 2020-10-30
 * @description
 */
public class BinaryTree {

    public static void main(String[] args) {

        BiTree node6 = new BiTree(6, null, null);
        BiTree node5 = new BiTree(5, null, null);
        BiTree node4 = new BiTree(4, null, null);
        BiTree node3 = new BiTree(3, null, null);
        BiTree node2 = new BiTree(2, node5, node6);
        BiTree node1 = new BiTree(1, node3, node4);
        BiTree bt = new BiTree(9, node1, node2);

        preOrder(bt);
        System.out.println("----------------");
        inOrder(bt);
        System.out.println("----------------");
        postOrder(bt);
    }

    public static void preOrder(BiTree root) {
        System.out.println(root.data);
        if (root.left != null) {
            preOrder(root.left);
        }
        if (root.right != null) {
            preOrder(root.right);
        }
    }

    public static void inOrder(BiTree root) {
        if (root.left != null) {
            inOrder(root.left);
        }
        System.out.println(root.data);
        if (root.right != null) {
            inOrder(root.right);
        }
    }

    public static void postOrder(BiTree root) {
        if (root.left != null) {
            postOrder(root.left);
        }
        if (root.right != null) {
            postOrder(root.right);
        }
        System.out.println(root.data);
    }

}

class BiTree {
    public int data;
    public BiTree left;
    public BiTree right;

    public BiTree() {
    }

    public BiTree(int data) {
        this.data = data;
    }

    public BiTree(int data, BiTree left, BiTree right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

}