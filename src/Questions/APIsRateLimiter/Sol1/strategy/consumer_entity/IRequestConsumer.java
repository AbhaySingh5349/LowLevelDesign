package Questions.APIsRateLimiter.Sol1.strategy.consumer_entity;

import Questions.APIsRateLimiter.Sol1.strategy.refill.IRefillRule;

public interface IRequestConsumer {
    String getRateLimitingId();
    IRefillRule getRefillRule();
}
