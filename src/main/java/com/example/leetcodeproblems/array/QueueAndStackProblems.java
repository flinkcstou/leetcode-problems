package com.example.leetcodeproblems.array;

import java.util.*;

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


//        MinStack minStack = new MinStack();
//
//        minStack.push(-1);
//        minStack.push(-1);
//        minStack.push(-1);
//
//        int top = minStack.top();
//        System.out.println();


//        int[] ints = dailyTemperaturesBest(new int[]{30, 40, 50, 60});
//        System.out.println(ints); // [1,1,4,2,1,1,0,0]

        int value = evalRPN(new String[]{"2", "1", "+", "3", "*"});
        System.out.println(value);
    }

    public static int evalRPN(String[] tokens) {
        // Можно реализовать более элегантно, сделай следующие шаги, создай Map вместо хэшмапа и укажи в значение FunctionalInterface, a stack сделай сразу Integer
        // Элегантный код есть в submissions
        Stack<String> stack = new Stack<>();

        Set<String> operations = new HashSet<>(List.of("-", "+", "*", "/"));

        for (String token : tokens) {

            stack.push(token);

            if (!operations.contains(token)) {
                continue;
            }
            if (stack.size() < 3) {
                return -1;
            }
            String operation = stack.pop();
            Integer second = Integer.valueOf(stack.pop());
            Integer first = Integer.valueOf(stack.pop());
            String result = "";

            if (Objects.equals(operation, "+")) {
                result = String.valueOf(first + second);
            } else if (Objects.equals(operation, "-")) {
                result = String.valueOf(first - second);
            } else if (Objects.equals(operation, "*")) {
                result = String.valueOf(first * second);
            } else if (Objects.equals(operation, "/")) {
                result = String.valueOf(first / second);
            } else {
                return -1;
            }
            stack.push(result);
        }
        if (stack.size() > 1) {
            return -1;
        }
        return Integer.parseInt(stack.pop());
    }

    public static int[] dailyTemperaturesBest(int[] temperatures) {
        // есть более элегантный способ решить эту задачу через stack/ Можно переписать этот код на более элегантный способ,
        // подсказка есть в solutions а перед этим моя подсказка, можешь испльзовать только index в stack, значения убрать и второе ты можешь  поднять while и удалть верхние ифки

        Deque<int[]> bigToSmall = new ArrayDeque<>();

        int[] days = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {

            int temperature = temperatures[i];

            if (bigToSmall.isEmpty()) {
                bigToSmall.addLast(new int[]{temperature, i});
                continue;
            }

            int[] values = bigToSmall.getLast();
            if (values[0] >= temperature) {
                bigToSmall.addLast(new int[]{temperature, i});
                continue;
            }

            while (!bigToSmall.isEmpty()) {
                values = bigToSmall.getLast();
                if (values[0] >= temperature) {
                    break;
                }
                days[values[1]] = i - values[1];
                bigToSmall.removeLast();
            }
            bigToSmall.addLast(new int[]{temperature, i});

        }
        return days;

    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] days = new int[temperatures.length];
        if (temperatures.length == 1) {
            return new int[]{0};
        }

        for (int i = 0; i < temperatures.length; i++) {
            days[i] = 0;
            int prevTemp = (i - 1 >= 0) ? temperatures[i - 1] : 0;
            int temp = temperatures[i];

            asd:
            for (int j = i + 1; j < temperatures.length; j++) {

                int warm = temperatures[j];

                if (prevTemp == temp) {
                    days[i] = days[i - 1] > 0 ? days[i - 1] - 1 : 0;
                    break asd;
                }
                if (temp < warm) {
                    days[i] = j - i;
                    break asd;
                }
            }

        }
        return days;

    }

    public static boolean isValid(String s) {

        Set<Character> openChars = new HashSet<>(List.of('(', '[', '{'));
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');

        Deque<Character> queue = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (openChars.contains(s.charAt(i))) {
                queue.add(s.charAt(i));
                continue;
            }
            if (queue.isEmpty()) {
                return false;
            }

            Character bracketTheOpenOfClosed = map.get(s.charAt(i));
            Character bracketTheOpen = queue.removeLast();

            if (bracketTheOpen != bracketTheOpenOfClosed) {
                return false;
            }

        }
        return queue.isEmpty();
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
