package Questions.APIsRateLimiter.Sol1.service;

import Questions.APIsRateLimiter.Sol1.model.TokenBucket;
import Questions.APIsRateLimiter.Sol1.strategy.consumer_entity.IRequestConsumer;
import Questions.APIsRateLimiter.Sol1.strategy.rateLimiterAlgo.IRateLimiter;
import Questions.APIsRateLimiter.Sol1.strategy.rateLimiterAlgo.TokenBucketRateLimiter;

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
    public void registerEntity(IRequestConsumer entity, int maxTokens) {
        TokenBucket bucket = new TokenBucket(maxTokens, System.currentTimeMillis());
        entityTokenBucketMap.put(entity.getRateLimitingId(), bucket);
    }

    // Method to check if a request is allowed
    public boolean isRequestAllowed(IRequestConsumer entity) {
        return rateLimiter.isRequestAllowed(entity);
    }
}
