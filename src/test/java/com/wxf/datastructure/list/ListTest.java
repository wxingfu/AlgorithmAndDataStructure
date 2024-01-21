package com.wxf.datastructure.list;

import com.wxf.node.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ListTest {

    private void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }


    @Test
    public void test() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode mergeTwoLists = mergeTwoLists(l1, l2);
        print(mergeTwoLists);

        // ListNode[] listNodes = {l1, l2};
        // ListNode mergeKLists = mergeKLists(listNodes);
        // print(mergeKLists);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1), p = dummy;
        ListNode p1 = l1, p2 = l2;
        while (p1 != null && p2 != null) {
            if (p1.val > p2.val) {
                p.next = p2;
                p2 = p2.next;
            } else {
                p.next = p1;
                p1 = p1.next;
            }
            p = p.next;
        }

        if (p1 != null) {
            p.next = p1;
        }

        if (p2 != null) {
            p.next = p2;
        }
        return dummy.next;
    }


    @Test
    public void test1() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] listNodes = {l1, l2, l3};

        ListNode mergedKLists = mergeKLists(listNodes);

        print(mergedKLists);

    }

    public ListNode mergeKLists(ListNode[] listNodes) {

        if (listNodes == null || listNodes.length == 0) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(listNodes.length, (o1, o2) -> o1.val - o2.val);

        for (ListNode head : listNodes) {
            if (head != null) {
                priorityQueue.add(head);
            }
        }

        while (!priorityQueue.isEmpty()) {
            // priorityQueue.forEach(item -> System.out.print(item.value + " "));

            ListNode current = priorityQueue.poll();
            p.next = current;
            if (current.next != null) {
                priorityQueue.add(current.next);
            }
            p = p.next;
            // System.out.println();
        }

        return dummy.next;

    }


    @Test
    public void test2() {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        l.next.next.next.next = new ListNode(5);
        ListNode fromEnd = findFromEnd(l, 2);

        System.out.println(fromEnd.val);
    }

    public ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        while (p1 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }

        return p2;
    }


    @Test
    public void test3() {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        l.next.next.next.next = new ListNode(5);
        ListNode removeNthFromEnd = removeNthFromEnd(l, 2);

        print(removeNthFromEnd);

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode x = findFromEnd(dummy, n + 1);
        x.next = x.next.next;
        return dummy.next;

    }


    @Test
    public void test4() {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        l.next.next.next.next = new ListNode(5);
        l.next.next.next.next.next = new ListNode(6);
        ListNode middleNode = middleNode(l);

        System.out.println(middleNode.val);

    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            // System.out.println(slow.value + " " + fast.value);
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    @Test
    public void test5() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        ListNode l8 = new ListNode(8);
        ListNode l9 = new ListNode(9);
        ListNode l0 = new ListNode(10);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
        l8.next = l9;
        l9.next = l0;
        l0.next = l3;

        boolean b = hasCycle(l1);
        System.out.println(b);
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        int i = 0;
        int j = 0;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            i++;
            fast = fast.next.next;
            j += 2;
            if (slow == fast) {
                System.out.println(i + " " + j + " " + slow.val);
                return true;
            }
        }

        return false;
    }


    @Test
    public void test6() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        ListNode l8 = new ListNode(8);
        ListNode l9 = new ListNode(9);
        ListNode l0 = new ListNode(10);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
        l8.next = l9;
        l9.next = l0;
        l0.next = l3;

        ListNode listNode = detectCycle(l1);
        System.out.println(listNode.val);
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        slow = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }


    @Test
    public void test7() {

        ListNode l1 = new ListNode(4);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(8);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(1);
        l2.next.next.next = new ListNode(8);
        l2.next.next.next.next = new ListNode(4);
        l2.next.next.next.next.next = new ListNode(5);

        ListNode intersectionNode = getIntersectionNode(l1, l2);

        System.out.println(intersectionNode.val);

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            // if (p1 != null && p2 != null && p1.value == p2.value) {
            //     break;
            // }
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }

        return p1;
    }


    @Test
    public void test8() {
        // 1,2,3,3,4,4,5
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(3);
        l1.next.next.next.next = new ListNode(4);
        l1.next.next.next.next.next = new ListNode(4);
        l1.next.next.next.next.next.next = new ListNode(5);

        ListNode listNode = deleteDuplicates(l1);
        print(listNode);

        List<List<Integer>> res = new ArrayList<>();
    }


    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1, head);

        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }

}
