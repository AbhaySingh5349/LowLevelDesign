package Questions.PaymentSystem.service;

import Questions.PaymentSystem.strategy.CardPaymentDetailsImpl;

public class CardPaymentThirdPartyService {
    public void pay(CardPaymentDetailsImpl cardPaymentDetails){
        System.out.println(cardPaymentDetails.toString());
    }
}
