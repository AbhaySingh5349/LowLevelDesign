package Questions.PaymentSystem.service;

import Questions.PaymentSystem.enums.PaymentMethod;
import Questions.PaymentSystem.strategy.IPaymentDetails;
import Questions.PaymentSystem.strategy.IPaymentHandler;

import java.util.List;

public class PaymentServiceListBased {
    List<IPaymentHandler> paymentHandlerList;

    public PaymentServiceListBased(List<IPaymentHandler> paymentHandlerList) {
        this.paymentHandlerList = paymentHandlerList;
    }

    public void pay(IPaymentDetails paymentDetails){
        
        for(IPaymentHandler paymentHandler : paymentHandlerList){
            if(paymentHandler.doesSupport(paymentDetails)){
                paymentHandler.support(paymentDetails);
            }
        }
    }
}
