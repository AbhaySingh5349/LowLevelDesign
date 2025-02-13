package Questions.APIsRateLimiter.Sol2.strategy.refill;

import Questions.APIsRateLimiter.Sol2.enums.RefillRuleType;
import Questions.APIsRateLimiter.Sol2.model.TokenBucket;

public class ConstantRateRefillRule implements IRefillRule {
    private final IRefillData refillData;

    public ConstantRateRefillRule(IRefillData refillData) {
        this.refillData = refillData;
    }

    @Override
    public boolean doesSupport(RefillRuleType refillRuleType) {
        return refillRuleType.equals(RefillRuleType.TOKEN_BUCKET_CONSTANT_RATE);
    }

    @Override
    public void refillBucket(TokenBucket bucket) {
        ConstantRateRefillData constantRateRefillData = (ConstantRateRefillData) refillData;

        Integer tokensToRefill = constantRateRefillData.getTokensToRefill();
        long tokensRefillWindowInMillis = constantRateRefillData.getTokensRefillWindowInMillis();

        long lastRefilledAt = bucket.getLastRefilledAt();

        long timeElapsed = System.currentTimeMillis() - lastRefilledAt;

        if(timeElapsed > tokensRefillWindowInMillis){
            bucket.refill(tokensToRefill);
            bucket.setLastRefilledAt(System.currentTimeMillis());
            System.out.println("BUCKET REFILLED: " + bucket.getCurTokens());
        }
    }
}