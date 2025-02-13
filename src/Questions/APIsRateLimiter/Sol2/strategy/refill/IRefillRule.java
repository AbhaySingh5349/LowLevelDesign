package Questions.APIsRateLimiter.Sol2.strategy.refill;

import Questions.APIsRateLimiter.Sol2.enums.RefillRuleType;
import Questions.APIsRateLimiter.Sol2.model.TokenBucket;

public interface IRefillRule {
    boolean doesSupport(RefillRuleType refillRuleType);
    void refillEntity(TokenBucket bucket);
}
