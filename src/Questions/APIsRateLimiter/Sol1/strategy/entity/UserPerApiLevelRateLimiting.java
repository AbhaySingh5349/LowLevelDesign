package Questions.APIsRateLimiter.Sol1.strategy.entity;

import Questions.APIsRateLimiter.Sol1.strategy.refill.IRefillRule;

public class UserPerApiLevelRateLimiting implements IRateLimitingEntity{
    private final String userId;
    private final String apiId;
    private final IRefillRule refillRule;

    public UserPerApiLevelRateLimiting(String userId, String apiId, IRefillRule refillRule) {
        this.userId = userId;
        this.apiId = apiId;
        this.refillRule = refillRule;
    }

    @Override
    public String getRateLimitingId() {
        return userId + "_" + apiId;
    }

    public IRefillRule getRefillRule() {
        return refillRule;
    }
}
