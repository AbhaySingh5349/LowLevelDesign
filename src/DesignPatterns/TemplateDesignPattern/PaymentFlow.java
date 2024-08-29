package DesignPatterns.TemplateDesignPattern;

public abstract class PaymentFlow {
    public abstract void validateRequest();
    public abstract void calculateFee();
    public abstract void debitAmount();
    public abstract void creditAmount();

    // template method to define order of execution of task
    public final void sendMoney(){
        validateRequest();
        calculateFee();
        debitAmount();
        creditAmount();
    }
}
