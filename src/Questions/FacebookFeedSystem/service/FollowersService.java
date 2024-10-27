package Questions.FacebookFeedSystem.service;

import Questions.FacebookFeedSystem.repository.IFollowersRepo;

import java.util.List;

public class FollowersService {
    private final IFollowersRepo followersRepo;

    public FollowersService(IFollowersRepo followersRepo) {
        this.followersRepo = followersRepo;
    }

    public void follow(String followerId, String followeeId){
        followersRepo.follow(followerId, followeeId);
    }

    public void unfollow(String followerId, String followeeId){
        followersRepo.unfollow(followerId, followeeId);
    }

    public List<String> getFollowers(String userId){
        return followersRepo.getFollowers(userId);
    }

    public void displayFollowers(String userId){
        List<String> followers = getFollowers(userId);
        System.out.println("*************************");
        System.out.println("followers of " + userId);
        followers.forEach(System.out::println);
        System.out.println("*************************");
    }
}
