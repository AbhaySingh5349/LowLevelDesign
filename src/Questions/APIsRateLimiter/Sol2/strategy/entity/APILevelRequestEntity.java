package Questions.APIsRateLimiter.Sol2.strategy.entity;

public class APILevelRequestEntity implements IRequestEntity {
    private String apiId;

    public APILevelRequestEntity(String apiId) {
        this.apiId = apiId;
    }

    @Override
    public String getRateLimitingId() {
        return apiId;
    }
}
