//https://leetcode.com/problems/merge-two-sorted-lists/
//Good Explanation - https://www.youtube.com/watch?v=KVf1Uuqfv8E&t
/*
You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
Return the head of the merged linked list.

Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:
Input: list1 = [], list2 = []
Output: []

Example 3:
Input: list1 = [], list2 = [0]
Output: [0]
 */

package com.alapan.dsalgo.leetcode;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class mergeTwoSortedLists { //Time Complexity is O(n+m). Space complexity is O(1)

    public ListNode mergeLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                dummy.next = l1;
                l1 = l1.next;
            } else {
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
        }
        if (l1 != null) {
            dummy.next = l1;
        } else {
            dummy.next = l2;
        }
        return head.next;
    }

    static void printList(ListNode Node) {
        while (Node != null) {
            System.out.print(Node.val + " ");
            Node = Node.next;
        }
    }

    public static void main(String[] args) {
        mergeTwoSortedLists obj = new mergeTwoSortedLists();

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        printList(obj.mergeLists(l1, l2));
    }

}
