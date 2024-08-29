package DesignPatterns.AdapterDesignPattern;

public class LegacyPaymentSystem {
    public void makePayment(int amountInCents) {
        System.out.println("Legacy payment of amount (in cents): " + amountInCents);
    }
}
