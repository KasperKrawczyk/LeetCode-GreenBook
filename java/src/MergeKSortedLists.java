public class MergeKSortedLists {

    public class ListNode {
        private int val;
        private ListNode next;

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

    //  time O(n), space O(1)
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        int left;
        int curRight;
        int right = lists.length - 1;
        while (right != 0) {
            left = 0;
            curRight = right;
            while (left < curRight) {
                lists[left] = mergeTwoLists(lists[left], lists[curRight]);
                left++;
                curRight--;
                if (left >= curRight) {
                    right = curRight;
                }
            }
        }
        return lists[0];

    }

    private ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        } else if (b == null) {
            return a;
        }

        ListNode cur;

        if (a.val >= b.val) {
            cur = b;
            cur.next = mergeTwoLists(a, b.next);
        } else {
            cur = a;
            cur.next = mergeTwoLists(a.next, b);
        }
        return cur;
    }


}
