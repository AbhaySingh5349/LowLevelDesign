package Questions.APIsRateLimiter.strategy.refill;

import Questions.APIsRateLimiter.model.TokenBucket;

public interface IRefillRule {
    void refillBucket(TokenBucket bucket);
}
