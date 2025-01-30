package Questions.APIsRateLimiter.Sol1.strategy.rateLimiterAlgo;

import Questions.APIsRateLimiter.Sol1.strategy.consumer_entity.IRequestConsumer;

public interface IRateLimiter {
    boolean isRequestAllowed(IRequestConsumer entity);
}
