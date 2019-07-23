package Array;

public class EArray<E> {
    private E[] data;
    private int size;

    /**
     * 构造函数，传入数组的容量capacity构造EArray
     * @param capacity
     */
    public EArray(int capacity) {
        data = (E[])new Object[capacity];
        size = 0;
    }

    /**
     * 默认数组的容量10
     */
    public EArray() {
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
    public void addLast(E e) {
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
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在任意位置插入一个新元素e
     * @param index
     * @param e
     */
    public void add(int index, E e) {
//        if (size == data.length) {
//            throw new IllegalArgumentException("添加元素失败，数组空间已满");
//        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("添加元素失败，要求插入index位置大于0且小于size");
        }
        if (size == data.length) {
            // 实现一下动态数组的功能，给数组扩容，此处是扩容2倍
            // java里的ArrayList是扩容1.5倍
            resize(2*data.length);
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
    E get(int index) {
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
    void set(int index, E e) {
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
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            // ==是值比较，equals()是引用比较
            if(data[i].equals(e)) {
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
    public int find(E e) {
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
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove Falid. Index is illegal");
        }
        E ret = data[index];
        for (int i = index+1; i < size; i++) {
            data[i-1] = data[i];
        }
        size--;
        data[size] = null;    // loitering objects != memory leak

        // 如果该数组元素少到原数组的四分之一，那么将这个函数的容量减半
        if (size == data.length/4 && data.length/2 != 0) {
            resize(data.length/2);
        }
        return ret;
    }

    /**
     * 从数组中删除第一个元素
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 从数组中删除最后一个元素
     * @return
     */
    public E removeLast() {
        return remove(size-1);
    }

    /**
     * 从数组中删除元素e
     * @param e
     */
    public void removeElement(E e) {
        int index = find(e);
        if(index != -1) {
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("EArray: size = %d, capacity = %d \n", size, data.length));
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

    /**
     * 扩容函数
     * @param newCapacitty
     */
    private void resize(int newCapacitty) {
        E[] newData = (E[])new Object[newCapacitty];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public static void main(String[] args) {
        EArray<Integer> arr = new EArray<Integer>();
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);

        arr.add(1, 100);
        System.out.println(arr);

        arr.addFirst(999);
        System.out.println(arr);

        arr.remove(2);
        System.out.println(arr);

        arr.removeElement(6);
        System.out.println(arr);
        arr.removeElement(7);
        System.out.println(arr);
        arr.removeElement(8);
        System.out.println(arr);
        arr.removeElement(9);
        System.out.println(arr);
        arr.removeElement(4);
        System.out.println(arr);
        arr.removeElement(2);
        System.out.println(arr);
//        arr.removeElement(1);
//        System.out.println(arr);

        arr.add(1, 100);
        System.out.println(arr);

    }
}
