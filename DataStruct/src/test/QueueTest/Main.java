package QueueTest;

import Queue.ArrayQueue;
import Queue.LoopQueue;

/**
 * @className Main
 * @Author lulu
 * @Date 2019-10-26 17:59
 **/
public class Main {
    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<Integer>();
        for (int i = 0; i < 9; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if(i % 3 == 0) {
                queue.dequeue();
            }
        }

        LoopQueue<Integer> loopQueue = new LoopQueue<Integer>();
        for (Integer i = 0; i < 9; i++) {
            loopQueue.enqueue(i);
            System.out.println(loopQueue);
            if(i % 3 == 0) {
                loopQueue.dequeue();
            }
        }

    }
}
