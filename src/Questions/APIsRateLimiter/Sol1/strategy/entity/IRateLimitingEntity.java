package Questions.APIsRateLimiter.Sol1.strategy.entity;

import Questions.APIsRateLimiter.Sol1.strategy.refill.IRefillRule;

public interface IRateLimitingEntity {
    String getRateLimitingId();
    IRefillRule getRefillRule();
}
