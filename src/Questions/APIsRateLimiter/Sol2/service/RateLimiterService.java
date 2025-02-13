package Questions.APIsRateLimiter.Sol2.service;

import Questions.APIsRateLimiter.Sol2.enums.RateLimitingAlgorithm;
import Questions.APIsRateLimiter.Sol2.model.TokenBucket;
import Questions.APIsRateLimiter.Sol2.strategy.entity.IRequestEntity;
import Questions.APIsRateLimiter.Sol2.strategy.rateLimiterAlgo.FixedWindowRateLimiter;
import Questions.APIsRateLimiter.Sol2.strategy.rateLimiterAlgo.IRateLimiter;
import Questions.APIsRateLimiter.Sol2.strategy.rateLimiterAlgo.TokenBucketRateLimiter;

import java.util.HashMap;
import java.util.Map;

public class RateLimiterService {
    private static RateLimiterService instance;
    private final IRateLimiter rateLimiter;
    private final Map<String, TokenBucket> entityTokenBucketMap;

    private RateLimiterService() {
        this.entityTokenBucketMap = new HashMap<>();
        this.rateLimiter = new TokenBucketRateLimiter(entityTokenBucketMap);
    }

    public static RateLimiterService getInstance(){
        if(instance == null){
            synchronized (RateLimiterService.class){
                if(instance == null){
                    instance = new RateLimiterService();
                }
            }
        }
        return instance;
    }

    // Method to register a rate-limiting entity
    public void registerEntity(IRequestEntity entity, int maxTokens) {
        TokenBucket bucket = new TokenBucket(maxTokens, System.currentTimeMillis());
        entityTokenBucketMap.put(entity.getRateLimitingId(), bucket);
    }

    // Method to check if a request is allowed
    public boolean isRequestAllowed(IRequestEntity entity) {
        return rateLimiter.isRequestAllowed(entity);
    }

    public static IRateLimiter createRateLimiter(RateLimitingAlgorithm algorithm) {
        switch (algorithm) {
            case TOKEN_BUCKET:
                return new TokenBucketRateLimiter();
            case FIXED_WINDOW:
                return new FixedWindowRateLimiter();
            default:
                throw new IllegalArgumentException("Unsupported rate limiting algorithm: " + algorithm);
        }
    }
}
