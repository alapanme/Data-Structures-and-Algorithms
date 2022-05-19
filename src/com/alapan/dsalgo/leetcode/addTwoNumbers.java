//https://leetcode.com/problems/add-two-numbers/

/*
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

Example 2:
Input: l1 = [0], l2 = [0]
Output: [0]

Example 3:
Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
 */

package com.alapan.dsalgo.leetcode;

class Listnode {
    int val;
    Listnode next;

    Listnode(int val) {
        this.val = val;
    }

}

public class addTwoNumbers {

    public Listnode add(Listnode l1, Listnode l2) {
        Listnode dummy_head = new Listnode(0);
        Listnode l3 = dummy_head;
        int l1_val, l2_val, current_sum, carry = 0, last_digit;
        while (l1 != null || l2 != null) {
            if (l1 != null) { //This is for when one number has 3 digits and one has 4 digits then the 3 digits one is supplied with 0
                l1_val = l1.val;
            } else {
                l1_val = 0;
            }
            if (l2 != null) {
                l2_val = l2.val;
            } else {
                l2_val = 0;
            }
            current_sum = l1_val + l2_val + carry;
            carry = current_sum / 10; //Visualise 6+4=10, carry would be 10/10=1
            last_digit = current_sum % 10; //Visualize 6+4=10, last digit would be 10%10=0

            Listnode new_node = new Listnode(last_digit);
            l3.next = new_node;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            l3 = l3.next;
        }
        if (carry > 0) {
            Listnode new_node = new Listnode(carry);
            l3.next = new_node;
            l3 = l3.next;
        }
        return dummy_head.next;
    }

    static void printList(Listnode Node) {
        while (Node != null) {
            System.out.print(Node.val + " ");
            Node = Node.next;
        }
    }

    public static void main(String[] args) {
        addTwoNumbers obj = new addTwoNumbers();
        Listnode l1 = new Listnode(2);
        l1.next = new Listnode(4);
        l1.next.next = new Listnode(3);

        Listnode l2 = new Listnode(5);
        l2.next = new Listnode(6);
        l2.next.next = new Listnode(4);

        printList(obj.add(l1, l2));
    }
}
