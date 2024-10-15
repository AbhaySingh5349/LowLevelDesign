package Questions.APIsRateLimiter.strategy.entity;

import Questions.APIsRateLimiter.strategy.refill.ConstantRateRefillRule;
import Questions.APIsRateLimiter.strategy.refill.IRefillRule;

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
