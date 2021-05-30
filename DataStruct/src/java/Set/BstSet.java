package Set;

import Tree.Bst;

/**
 * @className BstSet
 * @Author lulu
 * @Date 2019/12/7 8:15 上午
 * 以二分搜索树为底层实现的集合
 **/
public class BstSet<E extends Comparable<E>> implements Set<E> {

    private Bst<E> bst;
    public BstSet() {
        bst = new Bst<>();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public Boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.getSize();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
