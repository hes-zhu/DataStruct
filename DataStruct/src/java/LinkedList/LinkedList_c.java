package LinkedList;

/**
 * @className LinkedList1
 * @Author lulu
 * @Date 2019-10-30 17:14
 * 无虚拟头节点，加入tail节点
 * 从tail节点插入，从head节点删除
 **/
public class LinkedList_c<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }
        public Node(E e) {
            this(e, null);
        }
        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head, tail;
    int size;

    public LinkedList_c() {
        tail = null;
        head = null;
        size = 0;
    }

    // 获取链表中的元素个数
    public int getSize() {
        return size;
    }
    // 返回链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 在链表的tail位置添加新的元素e
    public void add(E e) {
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }
    // 获得链表的head位置的元素e
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("cannot remove from an empty queue.");
        }
        return head.e;
    }

    // 删除链表的head位置的元素为e
    public E remove() {
        if (isEmpty()) {
            throw new IllegalArgumentException("cannot remove from an empty queue.");
        }
        Node retNode = head;
        head = head.next;
        // 手动释放
        retNode.next = null;
        if (head == null) {
            tail = null;
        }
        size--;
        return retNode.e;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Node current = head; current!=null; current=current.next) {
            res.append(current + "->");
        }
        res.append("NULL Tail");

        return res.toString();
    }
}
