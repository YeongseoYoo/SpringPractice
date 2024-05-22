package exercise.generics;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class MyStackDemo {
    public static void main(String[] args) {
        MyStack<String> stackStr = new MyStack<>();

        System.out.println(stackStr.isEmpty());
        stackStr.push("a"); // 1
        stackStr.push("b"); // 2
        stackStr.push("c"); // 3

        System.out.println(stackStr.pop());
        System.out.println(stackStr.peek());

        System.out.println(stackStr.isEmpty());

        stackStr.printElements();
    }
}

class MyStack<T> {
    private ArrayList<T> elements;

    public MyStack() {
        elements = new ArrayList<>();
    }

    public void push(T element) {
        elements.add(element);
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elements.remove(elements.size() - 1);
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elements.get(elements.size() - 1);
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public void printElements() {
        for (T element : elements) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
