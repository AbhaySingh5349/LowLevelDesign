package Questions.PaymentSystem.service;

import Questions.PaymentSystem.enums.PaymentMethod;
import Questions.PaymentSystem.strategy.CardPaymentDetailsImpl;
import Questions.PaymentSystem.strategy.CashPaymentDetailsImpl;
import Questions.PaymentSystem.strategy.IPaymentDetails;

import java.util.HashMap;

public class PaymentServiceMapBased {
    HashMap<PaymentMethod, IPaymentDetails> paymentDetailsMap;

    public PaymentServiceMapBased(HashMap<PaymentMethod, IPaymentDetails> paymentDetailsMap) {
        this.paymentDetailsMap = paymentDetailsMap;
    }

    public void pay(PaymentMethod paymentMethod){
        IPaymentDetails paymentDetails = paymentDetailsMap.get(paymentMethod);

        if(paymentDetails instanceof CashPaymentDetailsImpl cashPaymentDetails){
            CashPaymentThirdPartyService cashPaymentThirdPartyService = new CashPaymentThirdPartyService(cashPaymentDetails);
            cashPaymentThirdPartyService.pay();
        } else if (paymentDetails instanceof CardPaymentDetailsImpl cardPaymentDetails) {
            CardPaymentThirdPartyService cardPaymentThirdPartyService = new CardPaymentThirdPartyService(cardPaymentDetails);
            cardPaymentThirdPartyService.pay();
        }
    }
}
