package Questions.APIsRateLimiter.Sol2.strategy.entity;

public class UserPerAPILevelRequestEntity implements IRequestEntity {
    private final String userId;
    private final String apiId;

    public UserPerAPILevelRequestEntity(String userId, String apiId) {
        this.userId = userId;
        this.apiId = apiId;
    }

    @Override
    public String getRateLimitingId() {
        return userId + "_" + apiId;
    }
}
