package TemplateDesignPattern;

public class PayMerchant extends PaymentFlow{
    @Override
    public void validateRequest() {
        System.out.println("validation logic for merchant");
    }

    @Override
    public void calculateFee() {
        System.out.println("fee calculation for merchant");
    }

    @Override
    public void debitAmount() {
        System.out.println("debit amount");
    }

    @Override
    public void creditAmount() {
        System.out.println("credit amount to merchant");
    }
}
