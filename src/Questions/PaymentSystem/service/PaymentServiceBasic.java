package Questions.PaymentSystem.service;

import Questions.PaymentSystem.enums.PaymentMethod;
import Questions.PaymentSystem.strategy.CardPaymentDetailsImpl;
import Questions.PaymentSystem.strategy.CashPaymentDetailsImpl;
import Questions.PaymentSystem.strategy.IPaymentDetails;

public class PaymentServiceBasic {
    public void pay(PaymentMethod paymentMethod, IPaymentDetails paymentDetails){
        if(paymentMethod.equals(PaymentMethod.CASH)){
            CashPaymentDetailsImpl cashPaymentDetails = (CashPaymentDetailsImpl) paymentDetails;
            CashPaymentThirdPartyService cashPaymentThirdPartyService = new CashPaymentThirdPartyService();
            cashPaymentThirdPartyService.pay(cashPaymentDetails);
        } else if (paymentMethod.equals(PaymentMethod.CARD)) {
            CardPaymentDetailsImpl cardPaymentDetails = (CardPaymentDetailsImpl) paymentDetails;
            CardPaymentThirdPartyService cardPaymentThirdPartyService = new CardPaymentThirdPartyService();
            cardPaymentThirdPartyService.pay(cardPaymentDetails);
        }
    }
}
