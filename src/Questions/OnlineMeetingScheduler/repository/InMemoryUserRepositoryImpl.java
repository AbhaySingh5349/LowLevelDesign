package Questions.OnlineMeetingScheduler.repository;

import Questions.OnlineMeetingScheduler.model.User;

import java.util.HashMap;
import java.util.Map;

public class InMemoryUserRepositoryImpl implements UserRepository{
    private final Map<String, User> userMap;

    public InMemoryUserRepositoryImpl() {
        this.userMap = new HashMap<>();
    }

    @Override
    public void addUser(User user) {
        userMap.put(user.getId(), user);
    }

    @Override
    public User getUser(String id) throws Exception {
        if(!userMap.containsKey(id)){
            throw new Exception("User not found");
        }
        return userMap.get(id);
    }

    @Override
    public void removeUser(String id) throws Exception {
        if(!userMap.containsKey(id)){
            throw new Exception("User not found");
        }
        userMap.remove(id);
    }
}
