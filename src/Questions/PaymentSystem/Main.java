package Questions.PaymentSystem;

import Questions.PaymentSystem.enums.PaymentMethod;
import Questions.PaymentSystem.service.PaymentServiceBasic;
import Questions.PaymentSystem.service.PaymentServiceListBased;
import Questions.PaymentSystem.service.PaymentServiceMapBased;
import Questions.PaymentSystem.strategy.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PaymentServiceBasic paymentServiceBasic = new PaymentServiceBasic();

        CashPaymentDetailsImpl cashPaymentDetails = new CashPaymentDetailsImpl(100);
        paymentServiceBasic.pay(PaymentMethod.CASH, cashPaymentDetails);

        CardPaymentDetailsImpl cardPaymentDetails = new CardPaymentDetailsImpl("sender_card_num", "sender_card_cvv", "receiver_bank_acc_num", 100);
        paymentServiceBasic.pay(PaymentMethod.CARD, cardPaymentDetails);

        System.out.println("\n********************************************************************************************\n");

        HashMap<PaymentMethod, IPaymentDetails> paymentDetailsMap = new HashMap<>();
        paymentDetailsMap.put(PaymentMethod.CASH, cashPaymentDetails);
        paymentDetailsMap.put(PaymentMethod.CARD, cardPaymentDetails);

        PaymentServiceMapBased paymentServiceMapBased = new PaymentServiceMapBased(paymentDetailsMap);

        paymentServiceMapBased.pay(PaymentMethod.CASH);
        paymentServiceMapBased.pay(PaymentMethod.CARD);

        System.out.println("\n********************************************************************************************\n");

        List<IPaymentHandler> paymentHandlerList = new ArrayList<>();
        paymentHandlerList.add(new CashPaymentHandlerImpl());
        paymentHandlerList.add(new CardPaymentHandlerImpl());

        PaymentServiceListBased paymentServiceListBased = new PaymentServiceListBased(paymentHandlerList);
        paymentServiceListBased.pay(cashPaymentDetails);
        paymentServiceListBased.pay(cardPaymentDetails);
    }
}
