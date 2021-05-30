package LinkedList;

import Stack.Stack;

/**
 * @className LinkedListStack
 * @Author lulu
 * @Date 2019-10-30 18:48
 * 用链表作为底层的栈的实现
 **/
public class LinkedListStack<E> implements Stack<E> {

    private LinkedList_b<E> list;

    public LinkedListStack() {
        list = new LinkedList_b<>();
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
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: Top ");
        res.append(list);
        return res.toString();
    }
}
