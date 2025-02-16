package com.example.leetcodeproblems.array;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    Queue<Integer> queue = new LinkedList<>();

    public MyStack() {
        this.queue = new LinkedList<>();
    }


    public void push(int x) {
        queue.offer(x);

        for (int i = 0; i < queue.size() - 1; i++) {
            queue.offer(queue.poll());
        }
    }

    public int pop() {
        return queue.remove();
    }

    public int top() {
        return queue.element();
    }

    public boolean empty() {
        return this.queue.isEmpty();
    }
}
