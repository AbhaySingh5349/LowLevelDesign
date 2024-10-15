package Questions.APIsRateLimiter.strategy.rateLimiterAlgo;

import Questions.APIsRateLimiter.strategy.entity.IRateLimitingEntity;

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
    public boolean isRequestAllowed(IRateLimitingEntity entity) {
        boolean primaryResponse = primaryRateLimiter.isRequestAllowed(entity);

        if(primaryResponse){
            return true;
        }

        return secondaryRateLimiter.isRequestAllowed(entity);
    }
}
