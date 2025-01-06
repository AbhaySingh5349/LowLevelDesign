package Questions.PaymentSystem.service;

import Questions.PaymentSystem.strategy.CashPaymentDetailsImpl;

public class CashPaymentThirdPartyService {
    CashPaymentDetailsImpl cashPaymentDetails;

    public CashPaymentThirdPartyService(CashPaymentDetailsImpl cashPaymentDetails) {
        this.cashPaymentDetails = cashPaymentDetails;
    }

    public void pay(){
        System.out.println(cashPaymentDetails.toString());
    }
}
