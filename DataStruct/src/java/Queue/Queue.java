package Queue;

/**
 * @className Queue
 * @Author lulu
 * @Date 2019-10-26 17:45
 **/
public interface Queue<E> {
    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
