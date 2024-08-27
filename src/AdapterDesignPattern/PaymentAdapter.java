package AdapterDesignPattern;

public class PaymentAdapter implements PaymentProcessor{
    private final LegacyPaymentSystem legacyPaymentSystem;

    public PaymentAdapter(LegacyPaymentSystem legacyPaymentSystem) {
        this.legacyPaymentSystem = legacyPaymentSystem;
    }

    @Override
    public void processPayment(double amountInDollars) {
        // Convert dollars to cents because the legacy system expects cents
        int amountInCents = (int) (amountInDollars * 100);
        legacyPaymentSystem.makePayment(amountInCents);
    }
}
