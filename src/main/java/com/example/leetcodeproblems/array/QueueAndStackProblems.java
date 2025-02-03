package com.example.leetcodeproblems.array;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

public class QueueAndStackProblems {

    public static void main(String[] args) {

//
//        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
//        boolean b = myCircularQueue.enQueue(7);// return True
//        boolean b1 = myCircularQueue.deQueue();// return True
//        int front = myCircularQueue.Front();// return -1
//        boolean b3 = myCircularQueue.deQueue();// return False
//        int rear = myCircularQueue.Front();// return -1
//        int rear1 = myCircularQueue.Rear(); // return -1
//        boolean b2 = myCircularQueue.enQueue(0); // return true;
//        boolean full = myCircularQueue.isFull(); // return false;
//        boolean b4 = myCircularQueue.deQueue(); // return true
//        int rear2 = myCircularQueue.Rear(); // return -1
//        boolean b5 = myCircularQueue.enQueue(3); // return true
//        System.out.println();


        MinStack minStack = new MinStack();

        minStack.push(-1);
        minStack.push(-1);
        minStack.push(-1);

        int top = minStack.top();
        System.out.println();
    }

    public static class MyCircularQueue {

        public int[] store;
        int head = -1;
        int tail = -1;

        public MyCircularQueue(int k) {
            store = new int[k];
        }

        public boolean enQueue(int value) {
            if (head == -1 || tail == -1) {
                head = 0;
                tail = 0;
                store[tail] = value;
                return true;
            }
            if (tail + 1 == head) {
                return false;
            }
            if (tail + 1 == store.length && head == 0) {
                return false;
            }
            if (tail + 1 == store.length) {
                tail = 0;
                store[tail] = value;
                return true;
            }
            tail++;
            store[tail] = value;
            return true;
        }

        public boolean deQueue() {
            if (head == -1 || tail == -1) {
                return false;
            }
            if (head == tail) {
                head = -1;
                tail = -1;
                return true;
            }
            head++;
            if (head == store.length) {
                head = 0;
            }
            return true;
        }

        public int Front() {
            if (head < 0 || head >= store.length) {
                return -1;
            }
            return store[head];
        }

        public int Rear() {
            if (tail < 0 || tail >= store.length) {
                return -1;
            }
            return store[tail];
        }

        public boolean isEmpty() {
            return head == -1 || tail == -1;
        }

        public boolean isFull() {
            if (tail + 1 == store.length && head == 0) {
                return true;
            }
            if (tail + 1 == head) {
                return true;
            }
            return false;
        }
    }

    public static class MinStack {
        // Изучить что такое PriorityQueue и как работает под капотом
        Deque<Integer> list = new LinkedList<>();
        Deque<Integer> minValue = new LinkedList<>();

        public MinStack() {

        }

        public void push(int val) {
            list.addLast(val);

            if (minValue.isEmpty()) {
                minValue.addLast(val);
            } else if (minValue.getLast() >= val) {
                minValue.addLast(val);
            }
        }

        public void pop() {
            if (list.isEmpty()) {
                return;
            }
            if (Objects.equals(minValue.getLast(), list.getLast())) {
                minValue.removeLast();
            }
            list.removeLast();
        }

        public int top() {
            if (list.isEmpty()) {
                return -1;
            }
            return list.getLast();
        }

        public int getMin() {
            if (list.isEmpty()) {
                return -1;
            }
            return minValue.getLast();
        }
    }
}
