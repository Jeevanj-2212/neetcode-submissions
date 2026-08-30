class Solution {
    public boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            // Slow moves one node at a time
            slow = slow.next;

            // Fast moves two nodes at a time
            fast = fast.next.next;

            // If they meet, there is a cycle
            if (slow == fast) {
                return true;
            }
        }

        // Fast reached the end, so there is no cycle
        return false;
    }
}