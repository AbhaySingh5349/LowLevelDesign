package Questions.PaymentSystem.service;

import Questions.PaymentSystem.enums.PaymentMethod;
import Questions.PaymentSystem.strategy.CardPaymentDetailsImpl;
import Questions.PaymentSystem.strategy.CashPaymentDetailsImpl;
import Questions.PaymentSystem.strategy.IPaymentDetails;

import java.util.HashMap;

// not viable as "key" type might change in future (eg. different for premium users, region based...)
// so better solution is to use List & at Interface level we check if we can handle that type of key or not
public class PaymentServiceMapBased {
    HashMap<PaymentMethod, IPaymentDetails> paymentDetailsMap;

    public PaymentServiceMapBased(HashMap<PaymentMethod, IPaymentDetails> paymentDetailsMap) {
        this.paymentDetailsMap = paymentDetailsMap;
    }

    public void pay(PaymentMethod paymentMethod){
        IPaymentDetails paymentDetails = paymentDetailsMap.get(paymentMethod);

        if(paymentDetails instanceof CashPaymentDetailsImpl cashPaymentDetails){
            CashPaymentThirdPartyService cashPaymentThirdPartyService = new CashPaymentThirdPartyService();
            cashPaymentThirdPartyService.pay(cashPaymentDetails);
        } else if (paymentDetails instanceof CardPaymentDetailsImpl cardPaymentDetails) {
            CardPaymentThirdPartyService cardPaymentThirdPartyService = new CardPaymentThirdPartyService();
            cardPaymentThirdPartyService.pay(cardPaymentDetails);
        }
    }
}
