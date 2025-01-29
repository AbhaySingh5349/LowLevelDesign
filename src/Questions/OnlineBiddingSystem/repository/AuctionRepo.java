package Questions.OnlineBiddingSystem.repository;

import Questions.OnlineBiddingSystem.model.Auction;
import Questions.OnlineBiddingSystem.model.Participant;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AuctionRepo {
    private final Map<String, Auction> auctionMap;
    private final Map<String, Set<Participant>> auctionParticipantMap;

    public AuctionRepo() {
        this.auctionMap = new HashMap<>();
        this.auctionParticipantMap = new HashMap<>();
    }

    public void addAuction(Auction auction){
        auctionMap.put(auction.getId(), auction);
    }

    public Auction getAuctionById(String id){
        return auctionMap.get(id);
    }

    public void addParticipant(String id, Participant participant){
        auctionParticipantMap.computeIfAbsent(id, k -> new HashSet<>()).add(participant);
    }

    public Set<Participant> getAllAuctionParticipant(String auctionId) {
        return auctionParticipantMap.get(auctionId);
    }
}
