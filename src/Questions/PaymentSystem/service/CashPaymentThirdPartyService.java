package Questions.PaymentSystem.service;

import Questions.PaymentSystem.strategy.CashPaymentDetailsImpl;

public class CashPaymentThirdPartyService {
    public void pay(CashPaymentDetailsImpl cashPaymentDetails){
        System.out.println(cashPaymentDetails.toString());
    }
}
