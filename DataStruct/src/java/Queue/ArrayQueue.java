package Queue;

import Array.EArray;

/**
 * @className ArrayQueue
 * @Author lulu
 * @Date 2019-10-26 17:49
 * 数组队列
 **/
public class ArrayQueue<E> implements Queue<E> {

    private EArray<E> array;

    public ArrayQueue(int capacity) {
        array = new EArray<E>(capacity);
    }

    public ArrayQueue() {
        array = new EArray<E>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize()-1) {
                res.append(", ");
            }
        }
        res.append("] end");
        return res.toString();
    }
}
