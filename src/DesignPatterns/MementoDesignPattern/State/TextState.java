package DesignPatterns.MementoDesignPattern.State;

public class TextState implements State {
    private final String text;

    public TextState(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "TextState{text='" + text + "'}";
    }
}
