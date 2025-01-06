package Questions.PaymentSystem.strategy;

import Questions.PaymentSystem.enums.PaymentMethod;
import Questions.PaymentSystem.service.CashPaymentThirdPartyService;

public class CashPaymentHandlerImpl implements IPaymentHandler{
    CashPaymentThirdPartyService cashPaymentThirdPartyService;

    public CashPaymentHandlerImpl() {
        this.cashPaymentThirdPartyService = new CashPaymentThirdPartyService();
    }

    @Override
    public boolean doesSupport(IPaymentDetails paymentDetails) {
        return paymentDetails.doesSupport(PaymentMethod.CASH);
    }

    @Override
    public void support(IPaymentDetails paymentDetails) {
        CashPaymentDetailsImpl cashPaymentDetails = (CashPaymentDetailsImpl) paymentDetails;
        cashPaymentThirdPartyService.pay(cashPaymentDetails);
    }
}
