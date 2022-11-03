package leetcode.hot100;


class ListNode {
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


public class RemoveNthFromEnd {

    /**
     * 双指针解法
     * 一趟遍历，p走到最后时，q停在距离p节点n个节点的位置
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        // 倒数第几个，就是中间隔几个
        ListNode p = head;
        int dis = 0;
        while (p != null && dis < n) {
            p = p.next;
            dis++;
        }
        if (p == null) {
            // 表示是去头
            head = head.next;
        } else {
            // 表示 去尾、去中间
            // Q Node xn P
            ListNode q = head;
            while (p != null) {
                q = q.next;
                p = p.next;
            }
            // 去尾
            if (n == 1) {
                q.next = null;
            } else {
                q.next = q.next.next;
            }
        }
        return head;

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int l = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            l++;
        }
        p = head;
        if (n == l) { // 去头
            head = p.next;
            p.next = null;
        } else { // 去中、去尾
            int iter = l - n - 1;
            while (iter > 0) {
                p = p.next;
                iter--;
            }
            if (n == 1) { // 去尾
                p.next = null;
            } else {
                p.next = p.next.next;
            }
        }
        return head;
    }
}
