package Questions.PaymentSystem.strategy;

import Questions.PaymentSystem.enums.PaymentMethod;

public interface IPaymentHandler {
    boolean doesSupport(IPaymentDetails paymentDetails);
    void support(IPaymentDetails paymentDetails);
}
