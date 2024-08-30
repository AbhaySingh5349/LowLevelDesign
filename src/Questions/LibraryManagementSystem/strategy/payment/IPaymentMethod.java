package Questions.LibraryManagementSystem.strategy.payment;

import Questions.LibraryManagementSystem.enums.PaymentType;
import Questions.LibraryManagementSystem.model.user.Member;

public interface IPaymentMethod {
    boolean isValidMethod(Member member, PaymentType paymentType);
    void processPayment(double amount, IPaymentDetails paymentDetails);
}