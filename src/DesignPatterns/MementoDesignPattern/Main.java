package DesignPatterns.MementoDesignPattern;

import DesignPatterns.MementoDesignPattern.State.NumericState;
import DesignPatterns.MementoDesignPattern.State.TextState;

public class Main {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        // Working with TextState
        originator.setState(new TextState("Hello"));
        caretaker.addMemento(originator.saveStateToMemento());

        originator.setState(new TextState("World"));
        caretaker.addMemento(originator.saveStateToMemento());

        originator.restoreStateFromMemento(caretaker.getLastMemento());  // Reverts to "Hello"
        originator.restoreStateFromMemento(caretaker.getLastMemento());  // Reverts to "World"

        // Working with NumericState
        originator.setState(new NumericState(42));
        caretaker.addMemento(originator.saveStateToMemento());

        originator.setState(new NumericState(100));
        caretaker.addMemento(originator.saveStateToMemento());

        originator.restoreStateFromMemento(caretaker.getLastMemento());  // Reverts to 42
        originator.restoreStateFromMemento(caretaker.getLastMemento());  // Reverts to 100
    }
}
