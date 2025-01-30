package Questions.APIsRateLimiter.Sol1.strategy.rateLimiterAlgo;

import Questions.APIsRateLimiter.Sol1.strategy.entity.IRateLimitingEntity;

public interface IRateLimiter {
    boolean isRequestAllowed(IRateLimitingEntity entity);
}
