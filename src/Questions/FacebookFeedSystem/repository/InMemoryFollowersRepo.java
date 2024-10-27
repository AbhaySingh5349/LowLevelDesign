package Questions.FacebookFeedSystem.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryFollowersRepo implements IFollowersRepo{
    private Map<String, List<String>> followersMap;

    public InMemoryFollowersRepo() {
        this.followersMap = new HashMap<>();
    }

    @Override
    public void follow(String followerId, String followeeId) {
        List<String> followees = followersMap.computeIfAbsent(followerId, k -> new ArrayList<>());

        if (!followees.contains(followeeId)) {
            followees.add(followeeId);
        }
    }

    @Override
    public void unfollow(String followerId, String followeeId) {
        List<String> followees = followersMap.computeIfAbsent(followerId, k -> new ArrayList<>());

        if (followees.contains(followeeId)) {
            followees.remove(followeeId);
        }
    }

    @Override
    public List<String> getFollowers(String userId) {
        return followersMap.getOrDefault(userId, new ArrayList<>());
    }
}
