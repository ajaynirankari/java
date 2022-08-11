package com.gl.leetCode.ValidParentheses;

import java.util.Stack;

public class Sample {
    public static void main(String[] args) {
        System.out.println(isValidParentheses("()"));
        System.out.println(isValidParentheses("()[]{}"));
        System.out.println(isValidParentheses("(]"));
    }

    static boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (isOpenParentheses(c)) {
                stack.push(c);
            }
            if (isCloseParentheses(c)) {
                if (stack.isEmpty()) {
                    return false;
                }
                if (!isMatchParentheses(stack.pop(), c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    static boolean isOpenParentheses(Character c) {
        return (c == '{' || c == '[' || c == '(');
    }

    static boolean isCloseParentheses(Character c) {
        return (c == '}' || c == ']' || c == ')');
    }

    static boolean isMatchParentheses(Character opening, Character closing) {
        return (opening == '{' && closing == '}') || (opening == '[' && closing == ']') || (opening == '(' && closing == ')');
    }
}
