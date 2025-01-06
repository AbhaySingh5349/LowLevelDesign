package Questions.PaymentSystem.strategy;

public class CardPaymentDetailsImpl implements IPaymentDetails{
    String senderCardNumber;
    String senderCardCVV;
    String receiverBankAccountId;
    int amount;

    public CardPaymentDetailsImpl(String senderCardNumber, String senderCardCVV, String receiverBankAccountId, int amount) {
        this.senderCardNumber = senderCardNumber;
        this.senderCardCVV = senderCardCVV;
        this.receiverBankAccountId = receiverBankAccountId;
        this.amount = amount;
    }

    public String getSenderCardNumber() {
        return senderCardNumber;
    }

    public void setSenderCardNumber(String senderCardNumber) {
        this.senderCardNumber = senderCardNumber;
    }

    public String getSenderCardCVV() {
        return senderCardCVV;
    }

    public void setSenderCardCVV(String senderCardCVV) {
        this.senderCardCVV = senderCardCVV;
    }

    public String getReceiverBankAccountId() {
        return receiverBankAccountId;
    }

    public void setReceiverBankAccountId(String receiverBankAccountId) {
        this.receiverBankAccountId = receiverBankAccountId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "CardPaymentDetailsImpl{" +
                "senderCardNumber='" + senderCardNumber + '\'' +
                ", senderCardCVV='" + senderCardCVV + '\'' +
                ", receiverBankAccountId='" + receiverBankAccountId + '\'' +
                ", amount=" + amount +
                '}';
    }
}
