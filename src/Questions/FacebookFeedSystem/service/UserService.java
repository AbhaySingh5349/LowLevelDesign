package Questions.FacebookFeedSystem.service;

import Questions.FacebookFeedSystem.model.User;
import Questions.FacebookFeedSystem.repository.IUserRepo;

import java.util.List;

public class UserService {
    private final IUserRepo userRepo;

    public UserService(IUserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void addUser(User user){
        userRepo.add(user);
    }

    public User getUserById(String id){
        return userRepo.getUserById(id);
    }

    List<User> getAllUsers(){
       return userRepo.getAllUsers();
    }
}
