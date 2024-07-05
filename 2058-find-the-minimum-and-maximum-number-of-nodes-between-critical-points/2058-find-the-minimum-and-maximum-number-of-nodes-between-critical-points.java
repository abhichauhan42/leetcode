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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
         if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }

        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = head.next.next;
        
        int pos = 1;  // Current position in the list
        int firstCriticalPos = -1;
        int lastCriticalPos = -1;
        int minDistance = Integer.MAX_VALUE;
        int prevCriticalPos = -1;

        while (next != null) {
            if ((curr.val > prev.val && curr.val > next.val) || 
                (curr.val < prev.val && curr.val < next.val)) {
                
                if (firstCriticalPos == -1) {
                    firstCriticalPos = pos;
                } else {
                    minDistance = Math.min(minDistance, pos - prevCriticalPos);
                }
                prevCriticalPos = pos;
                lastCriticalPos = pos;
            }

            prev = curr;
            curr = next;
            next = next.next;
            pos++;
        }

        if (firstCriticalPos == -1 || firstCriticalPos == lastCriticalPos) {
            return new int[]{-1, -1};
        }

        int maxDistance = lastCriticalPos - firstCriticalPos;

        return new int[]{minDistance, maxDistance};
    }
}