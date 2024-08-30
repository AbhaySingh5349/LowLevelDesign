package Questions.LibraryManagementSystem.strategy.payment;

public class GooglePayPaymentDetails implements IPaymentDetails {
    private final String senderUPI;
    private final String receiverUPI;

    public GooglePayPaymentDetails(String senderUPI, String receiverUPI) {
        this.senderUPI = senderUPI;
        this.receiverUPI = receiverUPI;
    }

    public String getSenderUPI() {
        return senderUPI;
    }

    public String getReceiverUPI() {
        return receiverUPI;
    }
}
