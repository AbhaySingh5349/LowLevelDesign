package Questions.APIsRateLimiter.Sol1.strategy.rateLimiterAlgo;

import Questions.APIsRateLimiter.Sol1.model.TokenBucket;
import Questions.APIsRateLimiter.Sol1.strategy.consumer_entity.IRequestConsumer;
import Questions.APIsRateLimiter.Sol1.strategy.refill.IRefillRule;

import java.util.Map;

public class TokenBucketRateLimiter implements IRateLimiter{
    private final Map<String, TokenBucket> entityTokenBucketMap; // each entity will have different token bucket

    public TokenBucketRateLimiter(Map<String, TokenBucket> entityTokenBucketMap) {
        this.entityTokenBucketMap = entityTokenBucketMap;
    }

    @Override
    public boolean isRequestAllowed(IRequestConsumer entity) {
        String entityId = entity.getRateLimitingId();
        IRefillRule refillRule = entity.getRefillRule();

        TokenBucket bucket = entityTokenBucketMap.get(entityId);
        refillRule.refillBucket(bucket);

        if(bucket.getCurTokens() > 0){
            bucket.consumeToken();

            return true;
        }

        return false;
    }
}
