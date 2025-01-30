package Questions.APIsRateLimiter.Sol1;

import Questions.APIsRateLimiter.Sol1.service.RateLimiterService;
import Questions.APIsRateLimiter.Sol1.strategy.consumer_entity.UserLevelRequestConsumer;
import Questions.APIsRateLimiter.Sol1.strategy.refill.ConstantRateRefillData;
import Questions.APIsRateLimiter.Sol1.strategy.refill.ConstantRateRefillRule;

public class Main {
    public static void main(String[] args) {
        /*
        // Define refill rule
        ConstantRateRefillData refillData = new ConstantRateRefillData(3, 2000L);
        ConstantRateRefillRule refillRule = new ConstantRateRefillRule(refillData);

        // Create a rate-limiting entity (e.g., User)
        UserLevelRateLimiting userEntity = new UserLevelRateLimiting("u1", refillRule);

        // Create Token Bucket for this user
        TokenBucket userBucket = new TokenBucket(5, System.currentTimeMillis());

        // Map entity to bucket
        Map<String, TokenBucket> entityTokenBucketMap = new HashMap<>();
        entityTokenBucketMap.put(userEntity.getRateLimitingId(), userBucket);

        // Create rate limiter
        TokenBucketRateLimiter rateLimiter = new TokenBucketRateLimiter(entityTokenBucketMap);

        // Simulate 15 API calls from the same user
        for (int i = 0; i < 15; i++) {
            boolean allowed = rateLimiter.isRequestAllowed(userEntity);
            System.out.println("Request " + (i + 1) + ": " + (allowed ? "✅ Allowed" : "❌ Blocked"));
            try {
                Thread.sleep(200); // Simulate small delay between requests
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
         */

        // Get singleton instance
        RateLimiterService rateLimiterService = RateLimiterService.getInstance();

        // Define refill rule (3 tokens per 2 sec)
        ConstantRateRefillData refillData = new ConstantRateRefillData(3, 1000L);
        ConstantRateRefillRule refillRule = new ConstantRateRefillRule(refillData);

        // Create rate-limiting entity (User Level)
        UserLevelRequestConsumer userConsumer = new UserLevelRequestConsumer("user_123", refillRule);

        // Register user entity with 5 max tokens & initial tokens
        rateLimiterService.registerEntity(userConsumer, 5);

        // Simulate 15 API requests
        for (int i = 0; i < 15; i++) {
            boolean allowed = rateLimiterService.isRequestAllowed(userConsumer);
            System.out.println("Request " + (i + 1) + ": " + (allowed ? "✅ Allowed" : "❌ Blocked"));
            try {
                Thread.sleep(200); // Simulate small delay between requests
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
