package TreeTest;

import Tree.Bst;

/**
 * @className BstTest
 * @Author lulu
 * @Date 2019/12/4 12:10 上午
 **/
public class BstTest_a {
    public static void main(String[] args) {
        Bst<Integer> bst = new Bst<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums) {
            bst.add(num);
        }
        bst.preOrder();

        bst.inOrder();

        bst.lastOrder();

        System.out.println();
        System.out.println(bst);

        bst.levelOrder();
    }
}
