package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @className Bst
 * @Author lulu
 * @Date 2019/11/30 5:13 下午
 * 二分搜索树
 **/
public class Bst<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left;
        public Node right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public Bst() {
        this.root = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public Boolean isEmpty() {
        return size == 0;
    }

    // 向二叉树添加元素
    public void add(E e) {
        // 采用递归算法1
        /* if (root == null) {
            root = new Node(e);
            size++;
        } else {
            this.add(root, e);
        } */

        // 采用递归算法2
        root = this.add(root, e);
    }

    // 向以root为根的二叉搜索树中添加元素e，递归算法----1
//    private void add(Node node, E e) {
//        if (node.e.equals(e)) {
//            return;
//        } else if (e.compareTo(node.e) < 0 && node.left == null) {
//            node.left = new Node(e);
//            size++;
//            return;
//        } else if (e.compareTo(node.e) > 0 && node.right == null) {
//            node.right = new Node(e);
//            size++;
//            return;
//        }
//        if (e.compareTo(node.e) < 0) {
//            add(node.left, e);
//        } else {
//            // 此时一定 e.compareTo(node.e) > 0
//            add(node.right, e);
//        }
//    }

    // 向以root为根的二叉搜索树中添加元素e，递归算法----2
    // 返回插入新节点后的二分搜索树
    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        } else {
            // 此时代表元素e与node当前节点相等
            // 不做处理
        }
        return node;
    }

    // 看二分搜索树中是否包含元素e
    public Boolean contains(E e) {
        return this.contains(root, e);
    }

    // 看以root为根的二分搜索树中是否包含元素e, 递归算法
    private Boolean contains(Node node, E e) {
        if (node == null) {
             return false;
        }
        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return this.contains(node.left, e);
        } else {
            //e.compareTo(node.e) > 0
            return this.contains(node.right, e);
        }
    }

    // 二分搜索树的前序遍历
    public void preOrder() {
        this.preOrder(root);
    }

    // 二分搜索树的前序遍历--非递归实现
    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();

            System.out.println(cur.e);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    // 二分搜索树的层序遍历
    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.println(cur.e);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    // 前序遍历以node为根的二分搜索树，递归算法
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.e+"\t");
        this.preOrder(node.left);
        this.preOrder(node.right);

        // 等价于
        /*if (node != null) {
            System.out.println(node.e);
            this.preOrder(node.left);
            this. preOrder(node.right);
        }*/
    }

    // 二分搜索树的中序遍历
    public void inOrder() {
        this.inOrder(root);
    }

    // 中序遍历以node为根的二分搜索树，递归算法
    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        this.inOrder(node.left);
        System.out.print(node.e+"\t");
        this.inOrder(node.right);
    }

    // 二分搜索树的后序遍历
    public void lastOrder() {
        this.lastOrder(root);
    }

    // 后序遍历以node为根的二分搜索树，递归算法
    private void lastOrder(Node node) {
        if (node == null) {
            return;
        }
        this.lastOrder(node.left);
        this.lastOrder(node.right);
        System.out.print(node.e+"\t");
    }

    // 寻找二分搜索树的最小元素
    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is Empty!");
        }
        return minimum(root).e;
    }

    // 返回以node为根的二分搜索树的最小值所在的节点
    public Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    // 寻找二分搜索树的最大元素
    public E maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is Empty!");
        }
        return maximum(root).e;
    }

    // 返回以node为根的二分搜索树的最大值所在的节点
    public Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    // 从二分搜索树中删除最小值所在节点，返回最小值
    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    // 删除以node为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    // 从二分搜索树中删除最大值所在节点，返回最大值
    public E removeMax() {
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    // 删除以node为根的二分搜索树中的最大节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    // 从二分搜索树中删除元素为e的节点
    public void remove(E e) {
        root = remove(root, e);
    }

    // 删除以node为根的二分搜索树中的值为e的节点，递归算法
    // 返回删除节点后新的二分搜索树的根
    private Node remove(Node node, E e) {
        if (node == null) {
            return node;
        }

        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else { // 此时 e == node.e

            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            // 待删除节点左右子树均不为空的情况
            // 找到比待删除节点大的最小节点，即待删除节点右子树的最小节点/(或者左子树的最大节点)
            // 用这个节点顶替待删除节点的位置
            Node successor = minimum(node);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;

            return successor;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBstTree(root, 0, res);
        return res.toString();
    }

    // 生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBstTree(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthString(depth)+"null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBstTree(node.left, depth+1, res);
        generateBstTree(node.right, depth+1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }
}






























