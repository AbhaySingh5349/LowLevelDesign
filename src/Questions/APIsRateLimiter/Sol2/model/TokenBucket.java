package Questions.APIsRateLimiter.Sol2.model;

import Questions.APIsRateLimiter.Sol2.strategy.refill.IRefillRule;

public class TokenBucket {
    private int maxTokensAllowed;
    private int curTokens;
    private Long lastRefilledAt;
    private final IRefillRule refillRule;

    public TokenBucket(int maxTokensAllowed, IRefillRule refillRule) {
        this.maxTokensAllowed = maxTokensAllowed;
        this.curTokens = maxTokensAllowed;
        this.lastRefilledAt = System.currentTimeMillis();
        this.refillRule = refillRule;
    }

    public int getMaxTokensAllowed() {
        return maxTokensAllowed;
    }

    public int getCurTokens() {
        return curTokens;
    }

    public Long getLastRefilledAt() {
        return lastRefilledAt;
    }

    public IRefillRule getRefillRule() {
        return refillRule;
    }

    public void setLastRefilledAt(Long lastRefilledAt) {
        this.lastRefilledAt = lastRefilledAt;
    }

    public void consumeToken(){
        curTokens--;
    }

    public void refill(Integer count){
        curTokens = Math.min(maxTokensAllowed, curTokens + count);
    }
}
