package Array;

import java.util.Arrays;

public class Array {

    private int[] data;
    private int size;

    /**
     * 构造函数，传入数组的容量capacity构造Array
     * @param capacity
     */
    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    /**
     * 默认数组的容量10
     */
    public Array() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在数组末尾添加元素
     * @param e
     */
    public void addLast(int e) {
        /*
        if (size == data.length) {
            throw new IllegalArgumentException("添加元素失败，数组空间已满");
        }
        data[size] = e;
        size++;
        */
        // 复用add方法
        add(size, e);
    }

    /**
     * 在数组头部添加元素
     * @param e
     */
    public void addFirst(int e) {
        add(0, e);
    }

    /**
     * 在任意位置插入一个新元素e
     * @param index
     * @param e
     */
    public void add(int index, int e) {
        if (size == data.length) {
            throw new IllegalArgumentException("添加元素失败，数组空间已满");
        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("添加元素失败，要求插入index位置大于0且小于size");
        }
        for (int i = size-1; i >= index; i--) {
            // 前面元素的值覆盖后面元素的值
            data[i+1] = data[i];
        }

        data[index] = e;
        size++;
    }

    /**
     * 获取索引位置的元素
     * @param index
     * @return
     */
    int get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get Falid. Index is illegal");
        }
        return data[index];
    }

    /**
     * 改变索引位置的元素
     * @param index
     * @param e
     */
    void set(int index, int e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set Falid. Index is illegal");
        }
        data[index] = e;
    }

    /**
     * 查找数组中是否含有元素e
     * @param e
     * @return
     */
    public boolean contains(int e) {
        for (int i = 0; i < size; i++) {
            if(data[i] == e) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
     * @param e
     * @return
     */
    public int find(int e) {
        for (int i = 0; i < size; i++) {
            if(data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 从数组中删除index位置的元素，返回删除的元素
     * @param index
     * @return
     */
    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove Falid. Index is illegal");
        }
        int ret = data[index];
        for (int i = index+1; i < size; i++) {
            data[i-1] = data[i];
        }
        size--;
        return ret;
    }

    /**
     * 从数组中删除第一个元素
     * @return
     */
    public int removeFirst() {
        return remove(0);
    }

    /**
     * 从数组中删除最后一个元素
     * @return
     */
    public int removeLast() {
        return remove(size-1);
    }

    /**
     * 从数组中删除元素e
     * @param e
     */
    public void removeElement(int e) {
        int index = find(e);
        if(index != -1) {
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d \n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size-1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }
}
