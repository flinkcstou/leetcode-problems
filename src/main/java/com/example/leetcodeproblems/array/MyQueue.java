package com.example.leetcodeproblems.array;

import java.util.Stack;

class MyQueue {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> stack_removed = new Stack<>();


    public MyQueue() {
        this.stack = new Stack<>();
        this.stack_removed = new Stack<>();
    }

    public void push(int x) {
        this.stack.push(x);
    }

    public int pop() {
        peek();
        return this.stack_removed.pop();
    }

    public int peek() {
        if (stack_removed.isEmpty()) {
            while (!stack.isEmpty()) {
                stack_removed.push(stack.pop());
            }
        }
        return stack_removed.peek();
    }

    public boolean empty() {
        return this.stack.isEmpty() && this.stack_removed.isEmpty();
    }
}