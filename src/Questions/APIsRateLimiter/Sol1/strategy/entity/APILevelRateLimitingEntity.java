package Questions.APIsRateLimiter.Sol1.strategy.entity;

import Questions.APIsRateLimiter.Sol1.strategy.refill.IRefillRule;

public class APILevelRateLimitingEntity implements IRateLimitingEntity{
    private String apiId;

    public APILevelRateLimitingEntity(String apiId) {
        this.apiId = apiId;
    }

    @Override
    public String getRateLimitingId() {
        return apiId;
    }

    @Override
    public IRefillRule getRefillRule() {
        return null;
    }
}
