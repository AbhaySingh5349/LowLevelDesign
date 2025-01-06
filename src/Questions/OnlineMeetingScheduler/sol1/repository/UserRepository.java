package Questions.OnlineMeetingScheduler.sol1.repository;

import Questions.OnlineMeetingScheduler.sol1.model.User;

public interface UserRepository {
    void addUser(User user);
    User getUser(String id) throws Exception;
    void removeUser(String id) throws Exception;
}
