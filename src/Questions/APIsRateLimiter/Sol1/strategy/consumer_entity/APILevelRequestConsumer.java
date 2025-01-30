package Questions.APIsRateLimiter.Sol1.strategy.consumer_entity;

import Questions.APIsRateLimiter.Sol1.strategy.refill.IRefillRule;

public class APILevelRequestConsumer implements IRequestConsumer {
    private String apiId;

    public APILevelRequestConsumer(String apiId) {
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
