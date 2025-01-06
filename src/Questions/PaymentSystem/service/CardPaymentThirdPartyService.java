package Questions.PaymentSystem.service;

import Questions.PaymentSystem.strategy.CardPaymentDetailsImpl;

public class CardPaymentThirdPartyService {
    CardPaymentDetailsImpl cardPaymentDetails;

    public CardPaymentThirdPartyService(CardPaymentDetailsImpl cardPaymentDetails) {
        this.cardPaymentDetails = cardPaymentDetails;
    }

    public void pay(){
        System.out.println(cardPaymentDetails.toString());
    }
}
