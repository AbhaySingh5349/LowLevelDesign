package Questions.APIsRateLimiter.strategy.rateLimiterAlgo;

import Questions.APIsRateLimiter.model.TokenBucket;
import Questions.APIsRateLimiter.strategy.entity.IRateLimitingEntity;
import Questions.APIsRateLimiter.strategy.refill.IRefillRule;

import java.util.Map;

public class TokenBucketRateLimiter implements IRateLimiter{
    private final Map<String, TokenBucket> entityTokenBucketMap; // each entity will have different token bucket

    public TokenBucketRateLimiter(Map<String, TokenBucket> entityTokenBucketMap) {
        this.entityTokenBucketMap = entityTokenBucketMap;
    }

    @Override
    public boolean isRequestAllowed(IRateLimitingEntity entity) {
        String entityId = entity.getRateLimitingId();
        IRefillRule refillRule = entity.getRefillRule();

        TokenBucket bucket = entityTokenBucketMap.get(entityId);
        refillRule.refillBucket(bucket);

        if(bucket.hasToken()){
            bucket.consumeToken();

            return true;
        }

        return false;
    }
}
