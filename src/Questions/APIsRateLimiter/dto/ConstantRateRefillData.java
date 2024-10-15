package Questions.APIsRateLimiter.dto;

public class ConstantRateRefillData implements IRefillData {
    // x num of tokens will be filled every y unit of time
    private final Integer tokensToRefill;
    private final Long tokensRefillWindowInMillis;

    public ConstantRateRefillData(Integer tokensToRefill, Long tokensRefillWindowInMillis) {
        this.tokensToRefill = tokensToRefill;
        this.tokensRefillWindowInMillis = tokensRefillWindowInMillis;
    }

    public Integer getTokensToRefill() {
        return tokensToRefill;
    }

    public Long getTokensRefillWindowInMillis() {
        return tokensRefillWindowInMillis;
    }
}
