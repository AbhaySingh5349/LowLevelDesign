package Questions.CoffeeMachine.enums;

public enum Bill {
    TEN(10),
    TWENTY(20),
    FIFTY(50);

    private final int value;

    Bill(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}