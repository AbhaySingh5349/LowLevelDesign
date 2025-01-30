package Questions.APIsRateLimiter.Sol1.strategy.refill;

import Questions.APIsRateLimiter.Sol1.dto.ConstantRateRefillData;
import Questions.APIsRateLimiter.Sol1.dto.IRefillData;
import Questions.APIsRateLimiter.Sol1.model.TokenBucket;

public class ConstantRateRefillRule implements IRefillRule{
    IRefillData refillData;

    public ConstantRateRefillRule(IRefillData refillData) {
        this.refillData = refillData;
    }

    @Override
    public void refillBucket(TokenBucket bucket) {
        Integer tokensToRefill = ((ConstantRateRefillData) refillData).getTokensToRefill();
        long tokensRefillWindowInMillis = ((ConstantRateRefillData) refillData).getTokensRefillWindowInMillis();;
        long lastRefilledAt = bucket.getLastRefilledAt();

        long timeElapsed = System.currentTimeMillis() - lastRefilledAt;

        if(timeElapsed > tokensRefillWindowInMillis){
            bucket.refill(tokensToRefill);
            bucket.setLastRefilledAt(System.currentTimeMillis());
        }
    }
}