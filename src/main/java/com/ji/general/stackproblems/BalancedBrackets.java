package com.ji.general.stackproblems;

import java.util.Stack;

// LC#20
public class BalancedBrackets {
    public static void main(String[] args) {
        System.out.println("Output for balanced brackets :" + isValid("()[]{}"));
        System.out.println("Output for balanced brackets :" + isValid("([)]"));
        System.out.println("Output for balanced brackets :" + isValid("[(?[,],,)]"));
        System.out.println("output for the backspace problem :" + backSpaceCompare("ab#c", "ad#c"));
        System.out.println("output for the backspace problem :" + backSpaceCompare("ab##", "c#d#"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        // [(}]
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
                continue;
            } else if (!stack.isEmpty() && stack.peek() == '{' && c == '}') {
                stack.pop();
            } else if (!stack.isEmpty() && stack.peek() == '[' && c == ']') {
                stack.pop();
            } else if ((!stack.isEmpty() && stack.peek() == '(' && c == ')')) {
                stack.pop();
            } else {
                continue;
            }
        }
        return stack.isEmpty();
    }

    // leetcode#844
    public static boolean backSpaceCompare(String s, String t) {

        return build(s).equals(build(t));
    }

    public static String build(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '#') {
                stack.push(c);
            } else if (!stack.isEmpty()) {
                stack.pop();
            }
        }
        return String.valueOf(stack);
    }
}
