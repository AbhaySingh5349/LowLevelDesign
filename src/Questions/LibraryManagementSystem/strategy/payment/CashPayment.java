package Questions.LibraryManagementSystem.strategy.payment;

import Questions.LibraryManagementSystem.enums.PaymentType;
import Questions.LibraryManagementSystem.model.user.Member;

public class CashPayment implements IPaymentMethod {
    @Override
    public boolean isValidMethod(Member member, PaymentType paymentType) {
        return paymentType.equals(PaymentType.CASH);
    }

    @Override
    public void processPayment(double amount, IPaymentDetails paymentDetails) {
        if (paymentDetails instanceof CashPaymentDetails) {
            // Process cash payment
            System.out.println("Processing cash payment of $" + amount);
        } else {
            throw new IllegalArgumentException("Invalid payment details for cash payment");
        }
    }
}
