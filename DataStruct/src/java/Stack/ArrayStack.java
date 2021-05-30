package Stack;

import Array.EArray;

/**
 * @className ArrayStack
 * @Author lulu
 * @Date 2019-10-26 15:28
 * 数组栈
 **/
public class ArrayStack<E> implements Stack<E> {

    EArray<E> array;

    public ArrayStack(int capacity) {
        array = new EArray<E>(capacity);
    }

    public ArrayStack() {
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
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Stack: ");
        stringBuilder.append("{");
        for (int i = 0; i < array.getSize(); i++) {
            stringBuilder.append(array.get(i));
            if (i != array.getSize() - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("} top");
        return stringBuilder.toString();
    }

    public int getCapacity() {
        return array.getCapacity();
    }
}
