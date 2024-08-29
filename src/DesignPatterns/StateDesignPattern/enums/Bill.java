package DesignPatterns.StateDesignPattern.enums;

public enum Bill {
    TEN(10),
    TWENTY(20),
    FIFTY(50);

    public final int value;

    Bill(int value) {
        this.value = value;
    }
}
