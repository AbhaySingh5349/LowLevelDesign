package Questions.APIsRateLimiter.Sol1.strategy.consumer_entity;

import Questions.APIsRateLimiter.Sol1.strategy.refill.IRefillRule;

public class UserPerAPILevelRequestConsumer implements IRequestConsumer {
    private final String userId;
    private final String apiId;
    private final IRefillRule refillRule;

    public UserPerAPILevelRequestConsumer(String userId, String apiId, IRefillRule refillRule) {
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
