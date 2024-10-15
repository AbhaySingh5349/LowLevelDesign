package Questions.APIsRateLimiter.strategy.entity;

import Questions.APIsRateLimiter.strategy.refill.IRefillRule;

public interface IRateLimitingEntity {
    String getRateLimitingId();
    IRefillRule getRefillRule();
}
