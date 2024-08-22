package TemplateDesignPattern;

public class PayFriend extends PaymentFlow{
    @Override
    public void validateRequest() {
        System.out.println("validation logic for friend");
    }

    @Override
    public void calculateFee() {
        System.out.println("fee calculation for friend");
    }

    @Override
    public void debitAmount() {
        System.out.println("debit amount");
    }

    @Override
    public void creditAmount() {
        System.out.println("credit amount to friend");
    }
}
