package MementoDesignPattern;

import java.util.Stack;

public class Caretaker {
    private final Stack<Memento> history = new Stack<>();

    public void addMemento(Memento memento) {
        history.push(memento);
    }

    public Memento getLastMemento() {
        if (!history.isEmpty()) {
            return history.pop();
        } else {
            System.out.println("Caretaker: No states to undo.");
            return null;
        }
    }
}