package Questions.FacebookFeedSystem.service;

import Questions.FacebookFeedSystem.model.Post;
import Questions.FacebookFeedSystem.strategy.feed.IFeedGenerationAlgoStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class FeedService {
    private final FollowersService followersService;
    private final PostService postService;
    private final IFeedGenerationAlgoStrategy feedGenerationAlgo;

    public FeedService(FollowersService followersService, PostService postService, IFeedGenerationAlgoStrategy feedGenerationAlgo) {
        this.followersService = followersService;
        this.postService = postService;
        this.feedGenerationAlgo = feedGenerationAlgo;
    }

    public void generateFeedForUser(String userId){
        List<String> followers = followersService.getFollowers(userId);
        followers.add(userId);

        List<Post> posts = followers.stream()
                .flatMap(id -> postService.getPostsByUserId(id).stream())
                .collect(Collectors.toList());

        List<Post> feedPosts = feedGenerationAlgo.generateFeed(posts, 10);
        displayFeed(feedPosts);

        followers.remove(userId);
    }

    private void displayFeed(List<Post> feedPosts) {
        System.out.println("*************************");
        feedPosts.stream()
                .map(post -> post.getUserId() + " -> " + post.getPostContent())
                .forEach(System.out::println);
        System.out.println("*************************");
    }
}
