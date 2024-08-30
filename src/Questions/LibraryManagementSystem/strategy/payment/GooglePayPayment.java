package Questions.LibraryManagementSystem.strategy.payment;

import Questions.LibraryManagementSystem.enums.PaymentType;
import Questions.LibraryManagementSystem.model.user.Member;

public class GooglePayPayment implements IPaymentMethod {
    @Override
    public boolean isValidMethod(Member member, PaymentType paymentType) {
        return paymentType.equals(PaymentType.CASH);
    }

    @Override
    public void processPayment(double amount, IPaymentDetails paymentDetails) {
        if (paymentDetails instanceof GooglePayPaymentDetails) {
            GooglePayPaymentDetails googlePayDetails = (GooglePayPaymentDetails) paymentDetails;
            // Process GooglePay payment
            System.out.println("Processing GooglePay payment of $" + amount +
                    " from " + googlePayDetails.getSenderUPI() +
                    " to " + googlePayDetails.getReceiverUPI());
        } else {
            throw new IllegalArgumentException("Invalid payment details for GooglePay payment");
        }
    }
}
