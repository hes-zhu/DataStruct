package LinkedListTest;

import LinkedList.LinkedListStack;
import Stack.ArrayStack;
import Stack.Stack;

import java.util.Random;

/**
 * @className TimeTest
 * @Author lulu
 * @Date 2019-10-26 21:28
 **/
public class StackTimeTest {

    private static double testQueue(Stack<Integer> stack, int count) {
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < count; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < count; i++) {
            stack.pop();
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        // 数小的时候链表栈比数组栈快，大的时候反之，我的电脑是这样
        int Count = 10000000;

        System.out.println("ArrayStack Time: "+testQueue(new ArrayStack<Integer>(), Count));
        System.out.println("LinkedListStack Time: "+testQueue(new LinkedListStack<Integer>(), Count));
    }
}
