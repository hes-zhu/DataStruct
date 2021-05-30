package Set;

/**
 * @className Set
 * @Author lulu
 * @Date 2019/12/7 8:13 上午
 **/
public interface Set<E> {
    void add(E e);
    void remove(E e);
    Boolean contains(E e);
    int getSize();
    boolean isEmpty();
}
