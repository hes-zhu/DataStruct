package LinkedListTest;

import LinkedList.LinkedListQueue;
import Queue.ArrayQueue;
import Queue.LoopQueue;
import Queue.Queue;

import java.util.Random;

/**
 * @className TimeTest
 * @Author lulu
 * @Date 2019-10-26 21:28
 **/
public class QueueTimeTest {

    private static double testQueue(Queue<Integer> q, int count) {
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < count; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < count; i++) {
            q.dequeue();
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int Count = 100000;

        System.out.println("ArrayQueue Time: "+testQueue(new ArrayQueue<Integer>(), Count));
        System.out.println("LoopQueue Time: "+testQueue(new LoopQueue<Integer>(), Count));
        System.out.println("LinkedListQueue Time: "+testQueue(new LinkedListQueue<>(), Count));
    }
}
