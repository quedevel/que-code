package leetcode.medium;

public class AddTwoNumbers {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode result = head;
        int carry = 0;
        while (l1 != null || l2 != null){
            int val1 = l1 != null? l1.val : 0;
            int val2 = l2 != null? l2.val : 0;
            int sum = val1 + val2 + carry;
            carry = sum/10;
            result.next = new ListNode(sum%10);
            result = result.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0) result.next = new ListNode(carry);
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        addTwoNumbers(l1, l2);
    }
}
