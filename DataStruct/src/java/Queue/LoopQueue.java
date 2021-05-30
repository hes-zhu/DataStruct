package Queue;

import java.util.Arrays;
import java.util.Objects;

/**
 * @className LoopQueue
 * @Author lulu
 * @Date 2019-10-26 20:33
 * 循环队列
 **/
public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front, tail;
    private int size;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length-1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {
        // 扩容队列
        if ((tail+1) % data.length == front) {
            resize(getCapacity()*2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    private void resize(int i) {
        E[] newData = (E[]) new Object[i + 1];
        for (int j = 0; j < size; j++) {
            newData[j] = data[(j+front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("这是一个空队列，无法再删除。。。");
        }
        E ret = data[front];
        data[front] = null;
        front = (front+1) % data.length;
        size--;
        // 缩小队列
        if (size == getCapacity()/4 && getCapacity()/2 != 0) {
            resize(getCapacity()/2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("这是一个空队列....");
        }
        return data[front];
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(String.format("Queue: size=%d, capacity=%d\n", size, getCapacity()));
        str.append("front [");
        for (int i = front; i != tail; i=(i+1) % data.length) {
            str.append(data[i]);
            if ((i+1) % data.length != tail) {
                str.append(", ");
            }
        }
        str.append("] end");
        return str.toString();
    }
}
