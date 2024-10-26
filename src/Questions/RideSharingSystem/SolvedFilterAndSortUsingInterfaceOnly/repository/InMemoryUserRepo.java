package Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.repository;

import Questions.NotificationService.model.User;

import java.util.HashMap;
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
    public User getById(String id) {
        return userMap.get(id);
    }
}
