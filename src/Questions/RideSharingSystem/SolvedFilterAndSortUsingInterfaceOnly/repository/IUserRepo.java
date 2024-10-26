package Questions.RideSharingSystem.SolvedFilterAndSortUsingInterfaceOnly.repository;

import Questions.NotificationService.model.User;

public interface IUserRepo {
    void add(User user);
    User getById(String id);
}
