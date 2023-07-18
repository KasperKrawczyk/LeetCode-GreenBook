public class SwapNodesInPairs {

    // time O(n), space O(1)
    public static ListNode swapPairs(ListNode n) {
        if(n == null) {
            return null;
        }
        if(n.next == null){
            return n;
        }
        ListNode toReturn = n;
        // for pointers form a window we manipulate within:
        // prev -> head -> neighbour -> next
        ListNode prev = n;
        ListNode head = n;
        ListNode neighbour;
        ListNode next;
        boolean isHead = true;
        while(head != null && head.next != null){
            if(isHead){
                neighbour = head.next;
                next = neighbour.next;
                neighbour.next = head;
                head.next = next;
                toReturn = neighbour;
                // now move the window
                head = next;
                isHead = false;
                continue;
            }

            neighbour = head.next;
            next = neighbour.next;
            neighbour.next = head;
            head.next = next;
            prev.next = neighbour;
            // now move the window
            prev = head;
            head = next;

        }
        return toReturn;
    }

    public static class ListNode {
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

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        ListNode head = swapPairs(l1);
        while(head != null){
            System.out.print(head.val + ", ");
            head = head.next;
        }
    }
}
