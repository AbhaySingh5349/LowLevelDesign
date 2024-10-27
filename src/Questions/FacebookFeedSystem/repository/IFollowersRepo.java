package Questions.FacebookFeedSystem.repository;

import java.util.List;

public interface IFollowersRepo {
    void follow(String followerId, String followeeId);
    void unfollow(String followerId, String followeeId);
    List<String> getFollowers(String userId);
}
