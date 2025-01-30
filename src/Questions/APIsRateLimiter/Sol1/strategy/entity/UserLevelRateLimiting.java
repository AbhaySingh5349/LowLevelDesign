package Questions.APIsRateLimiter.Sol1.strategy.entity;


import Questions.APIsRateLimiter.Sol1.strategy.refill.IRefillRule;

public class UserLevelRateLimiting implements IRateLimitingEntity{
    private final String userId;
    private final IRefillRule refillRule;

    public UserLevelRateLimiting(String userId, IRefillRule refillRule) {
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
