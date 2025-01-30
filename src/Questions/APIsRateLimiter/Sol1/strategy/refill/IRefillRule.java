package Questions.APIsRateLimiter.Sol1.strategy.refill;

import Questions.APIsRateLimiter.Sol1.model.TokenBucket;

public interface IRefillRule {
    void refillBucket(TokenBucket bucket);
}
