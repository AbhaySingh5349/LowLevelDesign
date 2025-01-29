package Questions.OnlineBiddingSystem.service;

import Questions.OnlineBiddingSystem.dto.BidRuleContext;
import Questions.OnlineBiddingSystem.enums.AuctionStatus;
import Questions.OnlineBiddingSystem.model.Auction;
import Questions.OnlineBiddingSystem.model.Bid;
import Questions.OnlineBiddingSystem.repository.BiddingRepo;
import Questions.OnlineBiddingSystem.strategy.actions.IActionDetails;
import Questions.OnlineBiddingSystem.strategy.actions.PlaceBidActionDetails;
import Questions.OnlineBiddingSystem.strategy.bid_rules.ISuccessBidRules;

import java.util.List;
import java.util.UUID;

public class BiddingService {
    private final List<ISuccessBidRules> successBidRules;
    private final BiddingRepo biddingRepository;
    private final AuctionService auctionService;

    public BiddingService(List<ISuccessBidRules> successBidRules, BiddingRepo biddingRepository, AuctionService auctionService) {
        this.successBidRules = successBidRules;
        this.biddingRepository = biddingRepository;
        this.auctionService = auctionService;
    }

    public void placeBid(IActionDetails details){
        if(!(details instanceof PlaceBidActionDetails)){
            throw new RuntimeException("Invalid Bid details");
        }

        PlaceBidActionDetails placeBidActionDetails = (PlaceBidActionDetails) details;
        String auctionId = placeBidActionDetails.getAuctionId();
        String userId = placeBidActionDetails.getUserId();
        int amount = placeBidActionDetails.getAmount();

        Auction auction = auctionService.getAuctionById(auctionId);
        Bid bid = new Bid(UUID.randomUUID().toString(), userId, amount, auctionId);
        Bid currentMaxBid = getMaxBidForAuction(auctionId);

        BidRuleContext context = new BidRuleContext();
        context.add("bid", bid);
        context.add("currentMaxBid", currentMaxBid);
        context.add("auction", auction);
        context.add("participants", auctionService.getAllAuctionParticipant(auctionId));

        for (ISuccessBidRules rules : successBidRules){
            if(!rules.validate(context)){
                System.out.println("Invalid Bid: " + rules);
                return;
            }
        }

        System.out.println("Bid placed successfully: " + bid);
        addBid(auctionId, bid);
    }

    public void addBid(String auctionId, Bid bid){
        biddingRepository.placeBid(auctionId, bid);
    }

    public Bid getMaxBidForAuction(String auctionId){
        return biddingRepository.getMaxBidForAuction(auctionId);
    }

    public List<Bid> getAllBidsForAuction(String auctionId){
        return biddingRepository.getAllBidsForAuction(auctionId);
    }
}
