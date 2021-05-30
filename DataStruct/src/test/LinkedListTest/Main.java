package LinkedListTest;

import LinkedList.LinkedList_b;

/**
 * @className Main
 * @Author lulu
 * @Date 2019-10-30 17:44
 **/
public class Main {
    public static void main(String[] args) {
        LinkedList_b<String> linkedList_b = new LinkedList_b<>();
        for (int i = 0; i < 6; i++) {
            linkedList_b.addFirst(i+"棒棒糖🍭");
            System.out.println(linkedList_b);
        }

        linkedList_b.add(3, "666");
        System.out.println(linkedList_b);
        linkedList_b.addLast("结束啰");
        System.out.println(linkedList_b);

        linkedList_b.remove(3);
        System.out.println(linkedList_b);
        linkedList_b.removeFirst();
        System.out.println(linkedList_b);
        linkedList_b.removeLast();
        System.out.println(linkedList_b);
    }
}
