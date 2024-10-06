package Questions.RideSharingSystem.repository;

import Questions.RideSharingSystem.model.User;

public interface IUserRepo {
    void add(User user);
    User get(String userId);
}
