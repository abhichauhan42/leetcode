class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        int carry = 0;
        ListNode result = null;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = (l1 != null ? l1.val : 0) +
                      (l2 != null ? l2.val : 0) + carry;

            carry = sum / 10;
            ListNode newNode = new ListNode(sum % 10);

            // Add the new node to the front of the result list
            newNode.next = result;
            result = newNode;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        ListNode prev = null;
        ListNode curr = result;
        ListNode next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
