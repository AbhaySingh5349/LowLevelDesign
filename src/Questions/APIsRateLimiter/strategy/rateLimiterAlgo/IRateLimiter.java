package Questions.APIsRateLimiter.strategy.rateLimiterAlgo;

import Questions.APIsRateLimiter.strategy.entity.IRateLimitingEntity;

public interface IRateLimiter {
    boolean isRequestAllowed(IRateLimitingEntity entity);
}
