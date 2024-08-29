package DesignPatterns.AdapterDesignPattern;

public class Main {
    public static void main(String[] args) {
        // Create an instance of the legacy payment system
        LegacyPaymentSystem legacyPaymentSystem = new LegacyPaymentSystem();

        // Create an adapter that makes the legacy system compatible with PaymentProcessor
        PaymentProcessor adapter = new PaymentAdapter(legacyPaymentSystem);

        // Use the adapter to process a payment
        adapter.processPayment(50.75);  // Processing $50.75
    }
}
