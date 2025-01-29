package Questions.OnlineBiddingSystem.repository;

import Questions.OnlineBiddingSystem.model.Bid;

import java.util.*;

public class BiddingRepo {
    private Map<String, List<Bid>> auctionBidsMap;

    public BiddingRepo() {
        this.auctionBidsMap = new HashMap<>();
    }

    public void placeBid(String auctionId, Bid bid){
        auctionBidsMap.computeIfAbsent(auctionId, k -> new ArrayList<>()).add(bid);
    }

    public Bid getMaxBidForAuction(String auctionId){
        List<Bid> bids = auctionBidsMap.getOrDefault(auctionId, List.of());
        return bids.stream().max((b1, b2) -> Integer.compare(b1.getValue(), b2.getValue())).orElse(null);
    }

    public List<Bid> getAllBidsForAuction(String auctionId){
        return auctionBidsMap.getOrDefault(auctionId, List.of());
    }
}
