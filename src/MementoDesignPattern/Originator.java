package MementoDesignPattern;

import MementoDesignPattern.State.State;

public class Originator {
    private State state;

    public void setState(State state) {
        System.out.println("Originator: Setting state to " + state);
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public Memento saveStateToMemento() {
        System.out.println("Originator: Saving to Memento.");
        return new Memento(state);
    }

    public void restoreStateFromMemento(Memento memento) {
        this.state = memento.getState();
        System.out.println("Originator: State after restore: " + state);
    }
}