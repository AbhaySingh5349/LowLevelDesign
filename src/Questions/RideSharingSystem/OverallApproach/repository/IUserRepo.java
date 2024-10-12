package Questions.RideSharingSystem.OverallApproach.repository;

import Questions.RideSharingSystem.OverallApproach.model.User;

public interface IUserRepo {
    void add(User user);
    User get(String userId);
}
