package Questions.APIsRateLimiter.Sol1.model;

public class TokenBucket {
    private Integer maxTokensAllowed;
    private Integer curTokens;
    private Long lastRefilledAt;

    public TokenBucket(Integer maxTokensAllowed, Long lastRefilledAt) {
        this.maxTokensAllowed = maxTokensAllowed;
        this.curTokens = maxTokensAllowed;
        this.lastRefilledAt = lastRefilledAt;
    }

    public Integer getCurTokens() {
        return curTokens;
    }

    public Long getLastRefilledAt() {
        return lastRefilledAt;
    }

    public void setLastRefilledAt(Long lastRefilledAt) {
        this.lastRefilledAt = lastRefilledAt;
    }

    public void consumeToken(){
        curTokens--;
    }

    public void refill(Integer count){
//        curTokens = Math.min(maxTokensAllowed, curTokens + count);
        curTokens += count;
    }
}
