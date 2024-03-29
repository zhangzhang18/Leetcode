package interview.linkList;


import interview.linkList.entity.ListNode;

/**
 * @Description:
 * @Author: zhangchunmeng
 * @Date: 2019-10-12
 */
public class ListMethod {
    public static void main(String[] args) {

    }

    void deleteDuplication(ListNode head) {
        ListNode preNode = null;
        ListNode node = head;

        while (node != null) {
            boolean needDelete = false;
            ListNode next = node.next;
            if (next != null && next.val == node.val) {
                needDelete = true;
            }
            if (needDelete) {
                int value = node.val;
                ListNode toBeDelete = node;
                while (toBeDelete != null && toBeDelete.val == value) {
                    next = toBeDelete.next;
                    deleteNode(toBeDelete);
                    toBeDelete = next;
                }

            } else {
                preNode = node;
                node = node.next;
            }
            if (preNode == null) {
                head = next;
            } else {
                preNode.next = next;
            }
            node = next;
        }
    }

    void deleteNode(ListNode toBeDelete) {

    }

    ListNode meetingNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head.next;
        if (slow == null) {
            return null;
        }
        ListNode fast = slow.next;
        while (slow != null && fast != null) {
            if (slow == fast) {
                return fast;
            }
            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }
        return null;
    }

    int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (key == arr[mid]) {
                return mid;
            } else if (key > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return 0;
    }

    boolean isIntersert(ListNode h1, ListNode h2) {
        if (h1 == null || h2 == null) {
            return false;
        }
        ListNode tail = h1;
        ListNode tail2 = h2;
        while (tail.next != null) {
            tail = tail.next;
        }
        while (tail2.next != null) {
            tail2 = tail2.next;
        }
        return tail == tail2;
    }

    public ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = null;
        ListNode now = head;
        while (now != null) {
            ListNode next = now.next;
            now.next = prev;
            prev = now;
            now = next;
        }
        return prev;
    }

    ListNode nodeOfLoop(ListNode head) {
        if (head == null) {
            return null;
        }
        //得到相遇节点
        ListNode meetingNode = meetingNode(head);
        if (meetingNode == null) {
            return null;
        }
        //得到环节点数
        int nodeInLoopNum = 1;
        ListNode p1 = meetingNode;
        while (p1.next != meetingNode) {
            p1 = p1.next;
            ++nodeInLoopNum;
        }
        p1 = head;
        ListNode p2 = head;
        //p1先移动环节点数nodeInLoopNum步
        for (int i = 0; i < nodeInLoopNum; i++) {
            p1 = p1.next;
        }
        //然后p1,p2以相同速度移动
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
