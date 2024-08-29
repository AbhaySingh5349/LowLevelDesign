package DesignPatterns.MediatorDesignPattern;

public class Main {
    public static void main(String[] args) {
        Mediator mediator = new Mediator();
        Bidder b1 = new Bidder("A", mediator);
        Bidder b2 = new Bidder("B", mediator);

        b1.placeBid(2000);
        b2.placeBid(2500);
        b1.placeBid(3000);
    }
}
