package Questions.PaymentSystem.strategy;

import Questions.PaymentSystem.enums.PaymentMethod;
import Questions.PaymentSystem.service.CardPaymentThirdPartyService;

public class CardPaymentHandlerImpl implements IPaymentHandler{
    CardPaymentThirdPartyService cardPaymentThirdPartyService;

    public CardPaymentHandlerImpl() {
        this.cardPaymentThirdPartyService = new CardPaymentThirdPartyService();
    }

    @Override
    public boolean doesSupport(IPaymentDetails paymentDetails) {
        return paymentDetails.doesSupport(PaymentMethod.CARD);
    }

    @Override
    public void support(IPaymentDetails paymentDetails) {
        CardPaymentDetailsImpl cardPaymentDetails = (CardPaymentDetailsImpl) paymentDetails;
        cardPaymentThirdPartyService.pay(cardPaymentDetails);
    }
}
