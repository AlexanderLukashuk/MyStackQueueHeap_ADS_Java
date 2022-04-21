package com.company;

public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {
    private static class MyNode<T>{
        T data;
        MyNode<T> next, prev;

        MyNode(T data) {
            this.data = data;
        }
    }

    private int length = 0;
    private MyNode<T> head, tail;

    public MyLinkedList() {}

    public void add(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    @Override
    public void add(T item, int index) {
        MyNode<T> newNode = new MyNode<>(item);
        if (head == null && index == 0) {
            head = tail = newNode;
        } else {
            int count = 0;
            for (MyNode<T> i = head; i != null; i = i.next) {
                if (count == (index - 1)) {
                    newNode.next = i.next;
                    newNode.prev = i;
                    i.next = newNode;
                }
                count++;
            }
        }
        length++;
    }

    @Override
    public boolean remove(T item) {
        if (item == head.data) {
            head.next.prev = null;
            head = head.next;
            length--;
            return true;
        } else if (item == tail.data) {
            tail = tail.prev;
            length--;
            return true;
        } else {
            MyNode<T> current = head;

            for (int i = 0; i < length; i++) {
                if (current.data == item) {
                    current.next.prev = current.prev;
                    current.prev.next = current.next;
                    length--;
                    return true;
                }
                current = current.next;
            }
            return false;
        }
    }

    @Override
    public T remove(int index) {
        MyNode<T> elem = head;
        int i = 1;

        while (i != index) {
            elem = elem.next;
            i++;
        }

        MyNode<T> current = elem.next;
        elem.next = current.next;
        length--;
        return current.data;
    }

    @Override
    public void clear() {
        head = tail = null;
        length = 0;
    }

    public T get(int index) {
        if (index >= length || index < 0)
            throw new IndexOutOfBoundsException("index should be positive and less than size");

        MyNode<T> temp = head;

        while (index != 0) {
            temp = temp.next;
            index--;
        }

        return temp.data;
    }

    @Override
    public int indexOf(Object o) {
        int count = 0;
        for (MyNode<T> i = head; i != null; i = i.next) {
            if (i.data == (T)o) {
                return count;
            }
            count++;
        }
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        int count = size() - 1;
        for (MyNode i = tail; i != head; i = i.prev) {
            if (i.data == (T)o) {
                return count;
            }
            count--;
        }
        return 0;
    }

    @Override
    public void sort() {
        if (length < 2) {
            return;
        }

        MyNode<T> node;

        for (int i = 0; i < length - 1; i++) {
            node = head;
            for (int j = i; j < length - i - 1; j++) {
                if ((node.data).compareTo(node.next.data) > 0) {
                    T temp = node.data;
                    node.data = node.next.data;
                    node.next.data = temp;
                }
                node = node.next;
            }
        }
    }

    public int size() {
        return length;
    }

    @Override
    public boolean contains(Object o) {
        for (MyNode<T> i = head; i != null; i = i.next) {
            if (i.data == (T)o) {
                return true;
            }
        }
        return false;
    }

    public void ShowList() {
        for (MyNode<T> i = head; i != null; i = i.next) {
            System.out.print(i.data + " ");
        }
        System.out.println();
    }

//    public T peek() {
//        if (tail != null) {
//            return (T) tail;
//        }
//        return null;
//    }

}