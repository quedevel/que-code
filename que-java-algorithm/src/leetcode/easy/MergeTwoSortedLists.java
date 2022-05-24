package leetcode.easy;

public class MergeTwoSortedLists {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return null;
        ListNode head = new ListNode(0);
        ListNode result = head;
        while(list1 != null && list2 != null){
            int val1 = list1 != null? list1.val:0;
            int val2 = list2 != null? list2.val:0;
            int next = val1 >= val2? val2:val1;
            if (val1 >= val2){
                next = val2;
                list2 = list2.next;
            } else {
                next = val1;
                list1 = list1.next;
            }
            result.next = new ListNode(next);
            result = result.next;
        }
        if (list1 == null) {
            while(list2 != null){
                result.next = new ListNode(list2.val);
                result = result.next;
                list2 = list2.next;
            }
        }
        if (list2 == null) {
            while(list1 != null){
                result.next = new ListNode(list1.val);
                result = result.next;
                list1 = list1.next;
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(-9, new ListNode(3));
        ListNode list2 = new ListNode(5,new ListNode(7));
        ListNode listNode = mergeTwoLists(list1, list2);
        System.out.println("listNode = " + listNode);
    }
}
