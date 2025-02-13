package Questions.APIsRateLimiter.Sol2.strategy.rateLimiterAlgo;

import Questions.APIsRateLimiter.Sol2.model.FixedWindow;
import Questions.APIsRateLimiter.Sol2.strategy.entity.IRequestEntity;

import java.util.HashMap;
import java.util.Map;

public class FixedWindowRateLimiter implements IRateLimiter{
    private final Map<String, FixedWindow> entityFixedWindowMap;

    public FixedWindowRateLimiter() {
        this.entityFixedWindowMap = new HashMap<>();
    }

    @Override
    public boolean isRequestAllowed(IRequestEntity entity) {
        return false;
    }
}
