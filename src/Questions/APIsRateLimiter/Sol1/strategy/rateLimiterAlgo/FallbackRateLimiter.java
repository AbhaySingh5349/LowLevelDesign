package Questions.APIsRateLimiter.Sol1.strategy.rateLimiterAlgo;

import Questions.APIsRateLimiter.Sol1.strategy.consumer_entity.IRequestConsumer;

public class FallbackRateLimiter implements IRateLimiter{
    private final IRateLimiter primaryRateLimiter;
    private final IRateLimiter secondaryRateLimiter;

    public FallbackRateLimiter(IRateLimiter primaryRateLimiter, IRateLimiter secondaryRateLimiter) {
        this.primaryRateLimiter = primaryRateLimiter;
        this.secondaryRateLimiter = secondaryRateLimiter;
    }

    public IRateLimiter getPrimaryRateLimiter() {
        return primaryRateLimiter;
    }

    public IRateLimiter getSecondaryRateLimiter() {
        return secondaryRateLimiter;
    }

    @Override
    public boolean isRequestAllowed(IRequestConsumer entity) {
        boolean primaryResponse = primaryRateLimiter.isRequestAllowed(entity);

        if(primaryResponse){
            return true;
        }

        return secondaryRateLimiter.isRequestAllowed(entity);
    }
}
