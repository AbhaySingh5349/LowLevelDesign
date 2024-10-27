package Questions.FacebookFeedSystem.repository;

import Questions.FacebookFeedSystem.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryUserRepo implements IUserRepo{
    private final Map<String, User> userMap;

    public InMemoryUserRepo() {
        this.userMap = new HashMap<>();
    }

    @Override
    public void add(User user) {
        String id = user.getId();
        userMap.put(id, user);
    }

    @Override
    public User getUserById(String userId) {
        return userMap.get(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(userMap.values());
    }
}
