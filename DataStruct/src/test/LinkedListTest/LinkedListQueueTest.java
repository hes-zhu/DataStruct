package LinkedListTest;

import LinkedList.LinkedListQueue;

/**
 * @className LinkedListQueueTest
 * @Author lulu
 * @Date 2019-10-30 19:32
 **/
public class LinkedListQueueTest {

    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();

        for (int i = 0; i < 6; i++) {
            queue.enqueue(i);
            System.out.println(queue);
        }

        queue.dequeue();
        System.out.println(queue);
        System.out.println(queue.getFront());
    }
}
