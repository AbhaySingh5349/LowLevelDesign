package Questions.DoctorBookingSystem.repository;


import Questions.DoctorBookingSystem.enums.UserType;
import Questions.DoctorBookingSystem.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserRepository {
    private final Map<String, User> userMap;

    public UserRepository() {
        this.userMap = new HashMap<>();
    }

    public void add(User user){
        userMap.put(user.getId(), user);
    }

    public User get(String id){
        return userMap.get(id);
    }

    public List<User> getAllDoctors(){
        List<User> users = new ArrayList<>(userMap.values());
        return users.stream().filter(user -> user.getUserType().equals(UserType.DOCTOR)).collect(Collectors.toList());
    }
}
