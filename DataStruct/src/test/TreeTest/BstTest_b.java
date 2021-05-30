package TreeTest;

import Tree.Bst;

import java.util.ArrayList;
import java.util.Random;

/**
 * @className BstTest
 * @Author lulu
 * @Date 2019/12/4 12:10 上午
 **/
public class BstTest_b {
    public static void main(String[] args) {
        Bst<Integer> bst = new Bst<>();
        Random random = new Random();

        int n = 1000;
        for (int i = 0; i < n; i++) {
            bst.add(random.nextInt(10000));
        }

        ArrayList<Integer> list = new ArrayList<>();
        while (!bst.isEmpty()) {
            list.add(bst.removeMin());
        }

        System.out.println(list);

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i-1) > list.get(i)) {
                throw new IllegalArgumentException("Fail");
            }
        }
        System.out.println("Test Success!");
    }
}
