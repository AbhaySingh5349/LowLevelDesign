package Questions.APIsRateLimiter.Sol2.strategy.refill;

import Questions.APIsRateLimiter.Sol2.enums.RefillRuleType;

public interface IRefillData {
    boolean doesSupport(RefillRuleType refillRuleType);
}
