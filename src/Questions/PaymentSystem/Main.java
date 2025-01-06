package Questions.PaymentSystem;

import Questions.PaymentSystem.enums.PaymentMethod;
import Questions.PaymentSystem.service.PaymentServiceBasic;
import Questions.PaymentSystem.strategy.CardPaymentDetailsImpl;
import Questions.PaymentSystem.strategy.CashPaymentDetailsImpl;

public class Main {
    public static void main(String[] args) {
        PaymentServiceBasic paymentService = new PaymentServiceBasic();

        CashPaymentDetailsImpl cashPaymentDetails = new CashPaymentDetailsImpl(100);
        paymentService.pay(PaymentMethod.CASH, cashPaymentDetails);

        CardPaymentDetailsImpl cardPaymentDetails = new CardPaymentDetailsImpl("sender_card_num", "sender_card_cvv", "receiver_bank_acc_num", 100);
        paymentService.pay(PaymentMethod.CARD, cardPaymentDetails);
    }
}
