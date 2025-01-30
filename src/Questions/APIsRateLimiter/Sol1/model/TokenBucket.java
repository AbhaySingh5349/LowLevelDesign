package Questions.APIsRateLimiter.Sol1.model;

public class TokenBucket {
    private Integer maxTokensAllowed;
    private Integer curTokens;
    private Long lastRefilledAt;

    public TokenBucket(Integer maxTokensAllowed, Integer curTokens, Long lastRefilledAt) {
        this.maxTokensAllowed = maxTokensAllowed;
        this.curTokens = curTokens;
        this.lastRefilledAt = lastRefilledAt;
    }

    public Long getLastRefilledAt() {
        return lastRefilledAt;
    }

    public void setLastRefilledAt(Long lastRefilledAt) {
        this.lastRefilledAt = lastRefilledAt;
    }

    public boolean hasToken(){
        return curTokens > 0;
    }

    public void consumeToken(){
        maxTokensAllowed--;
    }

    public void refill(Integer count){
        curTokens = Math.min(maxTokensAllowed, curTokens + count);
    }
}
