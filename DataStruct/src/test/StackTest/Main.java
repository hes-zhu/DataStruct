package StackTest;

import Stack.ArrayStack;

/**
 * @className Main
 * @Author lulu
 * @Date 2019-10-26 16:01
 **/
public class Main {
    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack = new ArrayStack<Integer>();

        for (int i = 0; i < 9; i++) {
            arrayStack.push(i);
            System.out.println(arrayStack);
        }

        arrayStack.pop();
        System.out.println(arrayStack);

        System.out.println(isValid("([]})"));
        System.out.println(isValid("()"));
        System.out.println(isValid("123"));
        System.out.println(isValid("([])"));
    }

    public static boolean isValid(String s) {
        ArrayStack<Character> stack = new ArrayStack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char topChar = stack.pop();
                if (c == ')' && topChar != '(') {
                    return false;
                }
                if (c == ']' && topChar != '[') {
                    return false;
                }
                if (c == '}' && topChar != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
