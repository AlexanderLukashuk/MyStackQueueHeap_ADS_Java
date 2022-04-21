package com.company;

public class Main {

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();

        System.out.println("Empty? " + stack.empty());
        System.out.println("Size = " + stack.size());
        System.out.println("Peek = " + stack.peek());

        stack.push(57);
        stack.push(73);
        stack.push(8);
        stack.push(14);
        stack.push(66);
        stack.push(21);

        System.out.println("Empty? " + stack.empty());
        System.out.println("Size = " + stack.size());
        System.out.println("Peek = " + stack.peek());
        stack.print();

        stack.pop();
        stack.pop();
        stack.pop();

        System.out.println("Empty? " + stack.empty());
        System.out.println("Size = " + stack.size());
        System.out.println("Peek = " + stack.peek());
        stack.print();

        MyQueue<Integer> queue = new MyQueue<>();

        System.out.println("Empty? " + queue.empty());
        System.out.println("Size = " + queue.size());
        System.out.println("Peek = " + queue.peek());

        queue.enqueue(49);
        queue.enqueue(7);
        queue.enqueue(125);
        queue.enqueue(38);
        queue.enqueue(51);
        queue.enqueue(101);
        queue.enqueue(1);

        System.out.println("Empty? " + queue.empty());
        System.out.println("Size = " + queue.size());
        System.out.println("Peek = " + queue.peek());
        queue.print();

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        System.out.println("Empty? " + queue.empty());
        System.out.println("Size = " + queue.size());
        System.out.println("Peek = " + queue.peek());
        queue.print();

        MyHeap<Integer> heap = new MyHeap<>();

        System.out.println("Empty? " + heap.empty());
        System.out.println("Size = " + heap.size());
        System.out.println("Peek = " + heap.getMin());

        heap.insert(44);
        heap.insert(23);
        heap.insert(133);
        heap.insert(19);
        heap.insert(199);
        heap.insert(55);

        System.out.println("Empty? " + heap.empty());
        System.out.println("Size = " + heap.size());
        System.out.println("Peek = " + heap.getMin());
        heap.print();
    }
}
