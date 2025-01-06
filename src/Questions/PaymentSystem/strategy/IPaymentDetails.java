package Questions.PaymentSystem.strategy;

import Questions.PaymentSystem.enums.PaymentMethod;

public interface IPaymentDetails {
    boolean doesSupport(PaymentMethod paymentMethod);
}
