package Questions.APIsRateLimiter.Sol2.strategy.entity;


public class UserLevelRequestEntity implements IRequestEntity {
    private final String userId;

    public UserLevelRequestEntity(String userId) {
        this.userId = userId;
    }

    @Override
    public String getRateLimitingId() {
        return userId;
    }
}
