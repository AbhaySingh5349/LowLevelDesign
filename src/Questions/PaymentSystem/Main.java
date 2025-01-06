package Questions.PaymentSystem;

import Questions.PaymentSystem.enums.PaymentMethod;
import Questions.PaymentSystem.service.PaymentServiceBasic;
import Questions.PaymentSystem.service.PaymentServiceMapBased;
import Questions.PaymentSystem.strategy.CardPaymentDetailsImpl;
import Questions.PaymentSystem.strategy.CashPaymentDetailsImpl;
import Questions.PaymentSystem.strategy.IPaymentDetails;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        PaymentServiceBasic paymentServiceBasic = new PaymentServiceBasic();

        CashPaymentDetailsImpl cashPaymentDetails = new CashPaymentDetailsImpl(100);
        paymentServiceBasic.pay(PaymentMethod.CASH, cashPaymentDetails);

        CardPaymentDetailsImpl cardPaymentDetails = new CardPaymentDetailsImpl("sender_card_num", "sender_card_cvv", "receiver_bank_acc_num", 100);
        paymentServiceBasic.pay(PaymentMethod.CARD, cardPaymentDetails);

        System.out.println("********************************************************************************************");

        HashMap<PaymentMethod, IPaymentDetails> paymentDetailsMap = new HashMap<>();
        paymentDetailsMap.put(PaymentMethod.CASH, cashPaymentDetails);
        paymentDetailsMap.put(PaymentMethod.CARD, cardPaymentDetails);

        PaymentServiceMapBased paymentServiceMapBased = new PaymentServiceMapBased(paymentDetailsMap);

        paymentServiceMapBased.pay(PaymentMethod.CASH);
        paymentServiceMapBased.pay(PaymentMethod.CARD);
    }
}
