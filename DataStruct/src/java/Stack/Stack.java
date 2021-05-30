package Stack;

/**
 * @className Stack
 * @Author lulu
 * @Date 2019-10-26 15:27
 **/
public interface Stack<E> {
    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
