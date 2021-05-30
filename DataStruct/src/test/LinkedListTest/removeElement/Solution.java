package LinkedListTest.removeElement;

/**
 * @className Solution
 * @Author lulu
 * @Date 2019-11-03 01:04
 * 203 移除链表元素
 **/
public class Solution {
    public ListNode removeElements(ListNode head, int val) {

        while (head != null && head.val == val) {
            ListNode cur = head;
            head = cur.next;
            cur.next = null;
        }

        if (head == null) {
            return null;
        }

        ListNode prev = head;
        while(prev.next != null) {
            if(prev.next.val == val) {
                ListNode cur = prev.next;
                prev.next = cur.next;
                cur.next = null;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }

}
