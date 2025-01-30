package Questions.APIsRateLimiter.Sol1.strategy.refill;

import Questions.APIsRateLimiter.Sol1.model.TokenBucket;

public class ConstantRateRefillRule implements IRefillRule{
    private final IRefillData refillData;

    public ConstantRateRefillRule(IRefillData refillData) {
        this.refillData = refillData;
    }

    @Override
    public void refillBucket(TokenBucket bucket) {
        ConstantRateRefillData constantRateRefillData = (ConstantRateRefillData) refillData;

        Integer tokensToRefill = constantRateRefillData.getTokensToRefill();
        long tokensRefillWindowInMillis = constantRateRefillData.getTokensRefillWindowInMillis();;

        long lastRefilledAt = bucket.getLastRefilledAt();

        long timeElapsed = System.currentTimeMillis() - lastRefilledAt;

        if(timeElapsed > tokensRefillWindowInMillis){
            bucket.refill(tokensToRefill);
            bucket.setLastRefilledAt(System.currentTimeMillis());
            System.out.println("BUCKET REFILLED: " + bucket.getCurTokens());
        }
    }
}