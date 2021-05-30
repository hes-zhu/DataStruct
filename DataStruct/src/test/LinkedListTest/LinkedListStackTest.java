package LinkedListTest;

import LinkedList.LinkedListStack;

/**
 * @className LinkedListStackTest
 * @Author lulu
 * @Date 2019-10-30 18:55
 **/
public class LinkedListStackTest {

    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();

        for (int i = 0; i < 6; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
        stack.peek();
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
    }
}
