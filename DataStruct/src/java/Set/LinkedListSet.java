package Set;

import LinkedList.LinkedList_b;

/**
 * @className LinkedListSet
 * @Author lulu
 * @Date 2019/12/7 3:02 下午
 * 以链表为底层实现的集合
 **/
public class LinkedListSet<E> implements Set<E> {

    private LinkedList_b<E> list;

    public LinkedListSet() {
        list = new LinkedList_b<>();
    }

    @Override
    public void add(E e) {
        if (!contains(e)) {
            list.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        list.removeElement(e);
    }

    @Override
    public Boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
