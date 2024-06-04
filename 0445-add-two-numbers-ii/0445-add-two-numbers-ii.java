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
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode first=reverse(l1);
        ListNode second=reverse(l2);
        
        int carry = 0;
        ListNode result = null;

        while (first != null || second != null || carry != 0) {
            int sum = (first != null ? first.val : 0) +
                      (second != null ? second.val : 0) + carry;

            carry = sum / 10;
            ListNode newNode = new ListNode(sum % 10);

            // Add the new node to the front of the result list
            newNode.next = result;
            result = newNode;

            if (first != null) first = first.next;
            if (second != null) second= second.next;
        }
        
       return result;        
    }
}