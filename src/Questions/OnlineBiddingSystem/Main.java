package Questions.OnlineBiddingSystem;

import Questions.OnlineBiddingSystem.enums.AuctionStatus;
import Questions.OnlineBiddingSystem.enums.ParticipantType;
import Questions.OnlineBiddingSystem.model.Bid;
import Questions.OnlineBiddingSystem.model.Participant;
import Questions.OnlineBiddingSystem.model.User;
import Questions.OnlineBiddingSystem.repository.AuctionRepo;
import Questions.OnlineBiddingSystem.repository.BiddingRepo;
import Questions.OnlineBiddingSystem.service.AuctionService;
import Questions.OnlineBiddingSystem.service.BiddingService;
import Questions.OnlineBiddingSystem.strategy.actions.PlaceBidActionDetails;
import Questions.OnlineBiddingSystem.strategy.bid_rules.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        AuctionRepo auctionRepo = new AuctionRepo();
        AuctionService auctionService = new AuctionService(auctionRepo);

        List<ISuccessBidRules> successBidRules = Arrays.asList(new AuctionStatusRule(), new DifferentBuyerThanMaxBidBuyerRule(),
                                                               new GreaterThanPrevBidRule(), new UserEligibilityRule());

        BiddingRepo biddingRepo = new BiddingRepo();
        BiddingService biddingService = new BiddingService(successBidRules, biddingRepo, auctionService);

        User u1 = new User("u1");
        User u2 = new User("u2");
        User u3 = new User("u3");
        User u4 = new User("u4");

        Participant p1 = new Participant(u2, ParticipantType.BUYER);
        Participant p2 = new Participant(u3, ParticipantType.BUYER);
        Participant p3 = new Participant(u4, ParticipantType.BUYER);

        auctionService.addAuction("a1", "book", u1, LocalDate.of(2025, 1,30), LocalDate.of(2025, 1,31));
        biddingService.addBid("a1", new Bid(UUID.randomUUID().toString(), "u1", 100, "a1"));
        auctionService.addParticipant("a1", p2);
        auctionService.addParticipant("a1", p3);
        auctionService.addParticipant("a1", p2);

        System.out.println(auctionService.getAllAuctionParticipant("a1"));

        Scanner scanner=new Scanner(System.in);

        while (true){
            String inp = scanner.nextLine();
            inp = inp.trim();

            String[] inpArr = inp.split(" ");

            if(inpArr.length < 2){
                System.out.println("Invalid Input !!");
                continue;
            }

            String cmd = inpArr[0];
            String auctionId = inpArr[1];

            switch (cmd){
                case "START_AUCTION":{
                    auctionService.updateAuctionStatus(auctionId, AuctionStatus.IN_PROGRESS);
                    System.out.println("Auction Begins!!\n");
                }
                break;
                case "END_AUCTION":{
                    auctionService.updateAuctionStatus(auctionId, AuctionStatus.CLOSED);
                    Bid maxBid = biddingService.getMaxBidForAuction(auctionId);
                    System.out.println("Auction winner: " + maxBid);
                    return;
                }
                case "PLACE_BID":{
                    String participantId = inpArr[2];
                    int amount = Integer.parseInt(inpArr[3]);
                    biddingService.placeBid(new PlaceBidActionDetails(participantId, auctionId, "dummy_item", amount));
                }
                break;
                case "GET_BIDS":{
                    List<Bid> bids = biddingService.getAllBidsForAuction(auctionId);
                    System.out.println(bids);
                }
                break;
                default:{
                    System.out.println("Invalid Command !!");
                }
            }
        }
    }
}
