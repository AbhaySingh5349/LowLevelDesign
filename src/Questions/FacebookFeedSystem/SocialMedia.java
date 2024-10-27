package Questions.FacebookFeedSystem;

import Questions.FacebookFeedSystem.enums.ContentType;
import Questions.FacebookFeedSystem.model.Post;
import Questions.FacebookFeedSystem.model.User;
import Questions.FacebookFeedSystem.repository.*;
import Questions.FacebookFeedSystem.service.FeedService;
import Questions.FacebookFeedSystem.service.FollowersService;
import Questions.FacebookFeedSystem.service.PostService;
import Questions.FacebookFeedSystem.service.UserService;
import Questions.FacebookFeedSystem.strategy.content.TextPostContent;
import Questions.FacebookFeedSystem.strategy.feed.PqAlgo;

public class SocialMedia {
    public static void main(String[] args) {
        IUserRepo userRepo = new InMemoryUserRepo();
        UserService userService = new UserService(userRepo);

        IPostRepo postRepo = new InMemoryPostRepo();
        PostService postService = new PostService(postRepo);

        IFollowersRepo followersRepo = new InMemoryFollowersRepo();
        FollowersService followersService = new FollowersService(followersRepo);

        FeedService feedService = new FeedService(followersService, postService, new PqAlgo());

        User a = new User("a", "a");
        User b = new User("b", "b");
        User c = new User("c", "c");
        User d = new User("d", "d");

        followersService.follow("a", "b");
        followersService.follow("a", "c");
        followersService.follow("a", "d");

        postService.add(new Post("1", "a", new TextPostContent("user a 1st post", ContentType.TEXT)));
        postService.add(new Post("2", "a", new TextPostContent("user a 2nd post", ContentType.TEXT)));
        postService.add(new Post("3", "b", new TextPostContent("user b 1st post", ContentType.TEXT)));
        postService.add(new Post("4", "c", new TextPostContent("user c 1st post", ContentType.TEXT)));
        postService.add(new Post("5", "d", new TextPostContent("user d 1st post", ContentType.TEXT)));

        feedService.generateFeedForUser("a");

        postService.delete("3");
        feedService.generateFeedForUser("a");

        followersService.unfollow("a", "c");
        feedService.generateFeedForUser("a");
    }
}
