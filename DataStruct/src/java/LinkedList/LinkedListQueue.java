package LinkedList;

import Queue.Queue;

/**
 * @className LinkedListQueue
 * @Author lulu
 * @Date 2019-10-30 19:10
 * 用链表作为底层的队列的实现
 **/
public class LinkedListQueue<E> implements Queue<E> {
    private LinkedList_c<E> list;

    public LinkedListQueue() {
        list = new LinkedList_c<>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        list.add(e);
    }

    @Override
    public E dequeue() {
        return list.remove();
    }

    @Override
    public E getFront() {
        return list.getFront();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: Top ");
        res.append(list);
        res.append(" Tail");
        return res.toString();
    }
}
