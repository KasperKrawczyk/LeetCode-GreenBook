public class ReverseLinkedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    // time O(n), space O(1)
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode prev = null;
        ListNode cur = head;
        ListNode next = head;

        while(cur != null){
            next = next.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    // time O(n), space O(1)
    public ListNode reverseListRec(ListNode head){
        return recUtil(head, null);
    }

    private ListNode recUtil(ListNode cur, ListNode nHead){
        if(cur == null){
            return nHead;
        }
        ListNode next = cur.next;
        cur.next = nHead;
        return recUtil(next, cur);
    }

}
