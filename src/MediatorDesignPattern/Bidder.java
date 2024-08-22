package MediatorDesignPattern;

public class Bidder {
    String name;
    Mediator mediator;

    public Bidder(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
        mediator.addBidder(this);
    }

    public String getName(){
        return this.name;
    }

    public void placeBid(Integer bidAmount){
        mediator.placeBid(this, bidAmount);
    }

    public void receiveNotification(String bidderName, Integer bidAmount){
        System.out.println(name + " received notification for bid placed by: " + bidderName + " with amt " + bidAmount);
    }
}
