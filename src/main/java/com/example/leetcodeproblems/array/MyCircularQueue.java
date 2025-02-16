package com.example.leetcodeproblems.array;

public class MyCircularQueue {

    int[] store;
    int head;
    int tail;
    int size;

    public MyCircularQueue(int k) {
        store = new int[k];
        size = k;
        head = -1;
        tail = -1;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        if(isEmpty()){
            head = 0;
        }
        tail = (tail + 1) % size;
        store[tail] = value;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        if (head == tail) {
            head = -1;
            tail = -1;
            return true;
        }
        head = (head + 1) + size;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }

        return store[head];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return store[tail];
    }

    public boolean isEmpty() {
        return head == -1;
    }

    public boolean isFull() {
        return ((tail + 1) % size) == head;
    }
}
