package MediatorDesignPattern;

import javax.swing.plaf.PanelUI;
import java.util.ArrayList;
import java.util.List;

public class Mediator {
    List<Bidder> bidders;

    public Mediator() {
        this.bidders = new ArrayList<>();
    }

    public void addBidder(Bidder bidder){
        bidders.add(bidder);
    }

    public void placeBid(Bidder bidder, Integer bidAmount){
        for(Bidder b : bidders){
            if(!b.getName().equals(bidder.getName())){
                b.receiveNotification(bidder.getName(), bidAmount);
            }
        }
    }
}
