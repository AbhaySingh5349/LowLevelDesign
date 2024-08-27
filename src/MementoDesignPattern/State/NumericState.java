package MementoDesignPattern.State;

public class NumericState implements State {
    private final int number;

    public NumericState(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "NumericState{number=" + number + "}";
    }
}
