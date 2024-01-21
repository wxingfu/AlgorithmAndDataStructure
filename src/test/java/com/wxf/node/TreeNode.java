package com.wxf.node;

public class TreeNode {

    //  节点值
    public int val;

    //  左节点指针
    public TreeNode left;

    // 右节点指针
    public TreeNode right;

    TreeNode() {

    }

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
