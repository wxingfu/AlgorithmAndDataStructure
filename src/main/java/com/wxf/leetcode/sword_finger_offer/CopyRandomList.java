package com.wxf.leetcode.sword_finger_offer;

import com.wxf.common.Node;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {


    Map<Node, Node> cachedNode = new HashMap<Node, Node>();

    public static void main(String[] args) {

    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!cachedNode.containsKey(head)) {
            Node headNew = new Node(head.val);
            cachedNode.put(head, headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return cachedNode.get(head);
    }
}
