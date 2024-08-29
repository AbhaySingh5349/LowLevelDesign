package Questions.ParkingLot.service;

import Questions.ParkingLot.model.ParkingTicket;
import Questions.ParkingLot.repository.ParkingSpotRepository;
import Questions.ParkingLot.repository.ParkingTicketRepository;
import Questions.ParkingLot.repository.TransactionRepository;
import Questions.ParkingLot.strategy.PaymentStrategy;
import Questions.ParkingLot.strategy.PricingStrategy;

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
