package Questions.OnlineMeetingScheduler.repository;

import Questions.OnlineMeetingScheduler.model.User;

public interface UserRepository {
    void addUser(User user);
    User getUser(String id) throws Exception;
    void removeUser(String id) throws Exception;
}
