package Questions.OnlineBiddingSystem.service;

import Questions.OnlineBiddingSystem.enums.AuctionStatus;
import Questions.OnlineBiddingSystem.enums.ParticipantType;
import Questions.OnlineBiddingSystem.model.Auction;
import Questions.OnlineBiddingSystem.model.Participant;
import Questions.OnlineBiddingSystem.model.User;
import Questions.OnlineBiddingSystem.repository.AuctionRepo;

import java.time.LocalDate;
import java.util.Set;

public class AuctionService {
    private final AuctionRepo auctionRepo;

    public AuctionService(AuctionRepo auctionRepo) {
        this.auctionRepo = auctionRepo;
    }

    public void addAuction(String id, String itemName, User seller, LocalDate start, LocalDate end){
        Auction auction = new Auction(id, itemName, start, end);
        Participant p = new Participant(seller, ParticipantType.SELLER);

        auctionRepo.addAuction(auction);
        auctionRepo.addParticipant(id, p);
    }

    public void updateAuctionStatus(String id, AuctionStatus status){
        Auction auction = auctionRepo.getAuctionById(id);
        auction.setStatus(status);
    }

    public Auction getAuctionById(String id){
        return auctionRepo.getAuctionById(id);
    }

    public void addParticipant(String auctionId, Participant participant){
        auctionRepo.addParticipant(auctionId, participant);
    }

    public Set<Participant> getAllAuctionParticipant(String auctionId){
        return auctionRepo.getAllAuctionParticipant(auctionId);
    }
}
