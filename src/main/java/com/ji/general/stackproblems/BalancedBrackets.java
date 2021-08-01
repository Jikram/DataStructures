package com.ji.general.stackproblems;

import java.util.Stack;
// LC#20
public class BalancedBrackets {
    public static void main(String[] args) {
        System.out.println("Output for balanced brackets :" +isValid("()[]{}"));
        System.out.println("Output for balanced brackets :" +isValid("([)]"));
        System.out.println("Output for balanced brackets :" +isValid("[(?[,],,)]"));
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
}
