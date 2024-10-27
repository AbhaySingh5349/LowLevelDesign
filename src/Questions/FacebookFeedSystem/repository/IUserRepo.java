package Questions.FacebookFeedSystem.repository;

import Questions.FacebookFeedSystem.model.User;

import java.util.List;

public interface IUserRepo {
    void add(User user);
    User getUserById(String userId);
    List<User> getAllUsers();
}
