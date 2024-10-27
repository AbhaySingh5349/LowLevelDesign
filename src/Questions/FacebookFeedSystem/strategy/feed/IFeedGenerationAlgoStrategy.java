package Questions.FacebookFeedSystem.strategy.feed;

import Questions.FacebookFeedSystem.model.Post;

import java.util.List;

public interface IFeedGenerationAlgoStrategy {
    List<Post> generateFeed(List<Post> posts, int topK);
}
