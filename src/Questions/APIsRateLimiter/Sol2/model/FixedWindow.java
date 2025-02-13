package Questions.APIsRateLimiter.Sol2.model;

import Questions.APIsRateLimiter.Sol2.strategy.refill.IRefillRule;

public class FixedWindow {
    private int requestCount;
    private long windowStartTime;
    private final long windowDuration;
    private final int maxRequests;
    private final IRefillRule refillRule;

    public FixedWindow(long windowDuration, int maxRequests, IRefillRule refillRule) {
        this.requestCount = 0;
        this.windowStartTime = System.currentTimeMillis();
        this.windowDuration = windowDuration;
        this.maxRequests = maxRequests;
        this.refillRule = refillRule;
    }

    public synchronized boolean allowRequest() {
        long currentTime = System.currentTimeMillis();

        // Reset the window if time has elapsed
        if (currentTime - windowStartTime > windowDuration) {
            windowStartTime = currentTime;
            requestCount = 0;
        }

        // Allow request if within limit
        if (requestCount < maxRequests) {
            requestCount++;
            return true;
        }

        return false;
    }
}
