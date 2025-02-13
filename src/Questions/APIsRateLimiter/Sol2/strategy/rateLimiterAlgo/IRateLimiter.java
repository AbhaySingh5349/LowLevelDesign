package Questions.APIsRateLimiter.Sol2.strategy.rateLimiterAlgo;

import Questions.APIsRateLimiter.Sol2.strategy.entity.IRequestEntity;

public interface IRateLimiter {
    boolean isRequestAllowed(IRequestEntity entity);
}
