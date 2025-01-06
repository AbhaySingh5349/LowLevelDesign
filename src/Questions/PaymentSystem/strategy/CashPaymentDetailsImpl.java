package Questions.PaymentSystem.strategy;

import Questions.PaymentSystem.enums.PaymentMethod;

public class CashPaymentDetailsImpl implements IPaymentDetails{
    int amount;

    public CashPaymentDetailsImpl(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "CashPaymentDetailsImpl{" +
                "amount=" + amount +
                '}';
    }

    @Override
    public boolean doesSupport(PaymentMethod paymentMethod) {
        return paymentMethod.equals(PaymentMethod.CASH);
    }
}
