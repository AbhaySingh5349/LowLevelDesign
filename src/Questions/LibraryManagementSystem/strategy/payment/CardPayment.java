package Questions.LibraryManagementSystem.strategy.payment;

import Questions.LibraryManagementSystem.enums.MemberType;
import Questions.LibraryManagementSystem.enums.PaymentType;
import Questions.LibraryManagementSystem.model.user.Member;

public class CardPayment implements IPaymentMethod {
    @Override
    public boolean isValidMethod(Member member, PaymentType paymentType) {
        return paymentType.equals(PaymentType.CARD) && member.getMembership().getMemberType().equals(MemberType.PREMIUM);
    }

    @Override
    public void processPayment(double amount, IPaymentDetails paymentDetails) {
        if (paymentDetails instanceof CardPaymentDetails) {
            CardPaymentDetails cardDetails = (CardPaymentDetails) paymentDetails;
            // Process card payment
            System.out.println("Processing card payment of $" + amount +
                    " using card number " + cardDetails.getCardNumber() +
                    " expiring on " + cardDetails.getExpMonth() + "/" + cardDetails.getExpYear() +
                    " with CVV " + cardDetails.getCvv() +
                    " to account " + cardDetails.getDestinationBankAccount());
        } else {
            throw new IllegalArgumentException("Invalid payment details for card payment");
        }
    }
}
