//You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
//
//You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//
//
//
//Example 1:
//
//
//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [7,0,8]
//Explanation: 342 + 465 = 807.
//Example 2:
//
//Input: l1 = [0], l2 = [0]
//Output: [0]
//Example 3:
//
//Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//Output: [8,9,9,9,0,0,0,1]

public class addTwoNum_2 {

     //Definition for singly-linked list.
     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            // VARIABLES
            int carry = 0;
            ListNode sum = new ListNode();
            ListNode itr = sum; // Set up iterator to not lose sum head


            // Add the numbers as we go through the list
            while (l1 != null || l2 != null) {

                // See if one of these is null if so adding needs to be done differently
                if (l1 == null) {
                    itr.val = l2.val  + carry;
                } else if (l2 == null){
                    itr.val = l1.val  + carry;
                } else {
                    itr.val = l1.val + l2.val + carry;
                }

                // Check if value is single digit and carrry if not
                if (itr.val > 9) {
                    carry = 1;
                    itr.val = itr.val - 10;
                }
                else {
                    carry = 0;
                }

                // Check if end of linked list and iterate to next node
                if (l1 != null) {
                    if (l1.next == null){
                        l1 = null;
                    } else {
                        l1 = l1.next;
                    }
                }
                if (l2 != null) {
                    if (l2.next == null){
                        l2 = null;
                    } else {
                        l2 = l2.next;
                    }
                }

                // Check if both nodes are EOL then check carry bit if at EOL and add to end
                if (l1 != null || l2 != null){
                    itr.next = new ListNode();
                    itr = itr.next;
                }
                else {
                    if (carry != 0){
                        itr.next = new ListNode();
                        itr = itr.next;
                        itr.val = 1;
                    }
                }
            }
            //Return head of sum list
            return sum;
        }
    }

}
