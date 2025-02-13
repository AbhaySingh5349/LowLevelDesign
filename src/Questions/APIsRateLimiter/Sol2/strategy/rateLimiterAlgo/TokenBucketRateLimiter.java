package Questions.APIsRateLimiter.Sol2.strategy.rateLimiterAlgo;

import Questions.APIsRateLimiter.Sol2.model.TokenBucket;
import Questions.APIsRateLimiter.Sol2.strategy.entity.IRequestEntity;
import Questions.APIsRateLimiter.Sol2.strategy.refill.IRefillRule;

import java.util.HashMap;
import java.util.Map;

public class TokenBucketRateLimiter implements IRateLimiter {
    private final Map<String, TokenBucket> entityTokenBucketMap; // each entity will have different token bucket

    public TokenBucketRateLimiter() {
        this.entityTokenBucketMap = new HashMap<>();
    }

    @Override
    public boolean isRequestAllowed(IRequestEntity entity) {
//        String entityId = entity.getRateLimitingId();
//        IRefillRule refillRule = entity.getRefillRule();
//
//        TokenBucket bucket = entityTokenBucketMap.get(entityId);
//        refillRule.refillBucket(bucket);
//
//        if(bucket.getCurTokens() > 0){
//            bucket.consumeToken();
//
//            return true;
//        }
//
//        return false;

        String entityId = entity.getRateLimitingId();

        TokenBucket bucket = entityTokenBucketMap.get(entityId);
        IRefillRule refillRule = bucket.getRefillRule();
        refillRule.refillBucket(bucket);

        return bucket.allowRequest();
    }
}
