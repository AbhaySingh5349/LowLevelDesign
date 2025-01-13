package Questions.ParkingLot.Sol1.service;

import Questions.ParkingLot.Sol1.model.ParkingTicket;
import Questions.ParkingLot.Sol1.repository.ParkingSpotRepository;
import Questions.ParkingLot.Sol1.repository.ParkingTicketRepository;
import Questions.ParkingLot.Sol1.repository.TransactionRepository;
import Questions.ParkingLot.Sol1.strategy.PaymentStrategy;
import Questions.ParkingLot.Sol1.strategy.PricingStrategy;

public class ExitService {
    private final ParkingSpotRepository spotRepository;
    private final ParkingTicketRepository ticketRepository;
    private final TransactionRepository transactionRepository;
    private final PricingStrategy pricingStrategy;
    private final PaymentStrategy paymentStrategy;

    public ExitService(ParkingSpotRepository spotRepository, ParkingTicketRepository ticketRepository,
                          TransactionRepository transactionRepository, PricingStrategy pricingStrategy,
                          PaymentStrategy paymentStrategy) {
        this.spotRepository = spotRepository;
        this.ticketRepository = ticketRepository;
        this.transactionRepository = transactionRepository;
        this.pricingStrategy = pricingStrategy;
        this.paymentStrategy = paymentStrategy;
    }

    public void processExit(String ticketId) {
        ParkingTicket ticket = ticketRepository.getTicketById(ticketId);
        if (ticket != null) {
            double amount = pricingStrategy.calculatePrice(calculateDuration(ticket.getIssuedAt()));
            if (paymentStrategy.pay(amount)) {
                spotRepository.getSpotById(ticket.getSpotId()).setAvailable(true);
                transactionRepository.addTransaction(ticketId, amount);
            }
        }
    }

    private long calculateDuration(long issuedAt) {
        return System.currentTimeMillis() - issuedAt;
    }
}
