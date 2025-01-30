package Questions.APIsRateLimiter.Sol1.strategy.consumer_entity;


import Questions.APIsRateLimiter.Sol1.strategy.refill.IRefillRule;

public class UserLevelRequestConsumer implements IRequestConsumer {
    private final String userId;
    private final IRefillRule refillRule;

    public UserLevelRequestConsumer(String userId, IRefillRule refillRule) {
        this.userId = userId;
        this.refillRule = refillRule;
    }

    @Override
    public String getRateLimitingId() {
        return userId;
    }

    @Override
    public IRefillRule getRefillRule() {
        return refillRule;
    }
}
