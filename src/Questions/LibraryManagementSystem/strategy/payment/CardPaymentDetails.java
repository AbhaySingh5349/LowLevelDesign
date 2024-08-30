package Questions.LibraryManagementSystem.strategy.payment;

public class CardPaymentDetails implements IPaymentDetails {
    private final String cardNumber;
    private final int expMonth;
    private final int expYear;
    private final String cvv;
    private final String destinationBankAccount;

    public CardPaymentDetails(String cardNumber, int expMonth, int expYear, String cvv, String destinationBankAccount) {
        this.cardNumber = cardNumber;
        this.expMonth = expMonth;
        this.expYear = expYear;
        this.cvv = cvv;
        this.destinationBankAccount = destinationBankAccount;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public int getExpMonth() {
        return expMonth;
    }

    public int getExpYear() {
        return expYear;
    }

    public String getCvv() {
        return cvv;
    }

    public String getDestinationBankAccount() {
        return destinationBankAccount;
    }
}

