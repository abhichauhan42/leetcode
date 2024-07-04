/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeNodes(ListNode head) {
           // Initialize a dummy node for the result linked list
        ListNode dummy = new ListNode(0);
        ListNode currentResult = dummy;
        int currentSum = 0;

        // Initialize a pointer to traverse the input list
        ListNode current = head.next; // Skip the first node which is guaranteed to be zero

        while (current != null) {
            if (current.val == 0) {
                // When we hit a zero, create a new node with the current sum and reset the sum
                currentResult.next = new ListNode(currentSum);
                currentResult = currentResult.next;
                currentSum = 0;
            } else {
                // Accumulate the values between zeros
                currentSum += current.val;
            }
            current = current.next;
        }

        return dummy.next;
    }
}