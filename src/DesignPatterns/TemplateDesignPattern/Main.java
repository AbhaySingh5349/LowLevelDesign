package DesignPatterns.TemplateDesignPattern;

public class Main {
    public static void main(String[] args) {
        PaymentFlow friendFlow = new PayFriend();
        friendFlow.sendMoney();

        System.out.println("*****");

        PaymentFlow merchantFlow = new PayMerchant();
        merchantFlow.sendMoney();
    }
}
