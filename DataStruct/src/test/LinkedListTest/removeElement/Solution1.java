package LinkedListTest.removeElement;

/**
 * @className Solution
 * @Author lulu
 * @Date 2019-11-03 01:04
 * 203 移除链表元素
 **/
public class Solution1 {
    public ListNode removeElements(ListNode head, int val) {

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while(prev.next != null) {
            if(prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }

}
