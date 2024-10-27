package Questions.FacebookFeedSystem.strategy.feed;

import Questions.FacebookFeedSystem.model.Post;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortingAlgo implements IFeedGenerationAlgoStrategy{
    @Override
    public List<Post> generateFeed(List<Post> posts, int topK) {
//        posts.sort((p1, p2) -> {
//            return Long.compare(p2.getTimestamp(), p1.getTimestamp()); // descending
//        });

        return posts.stream()
                .sorted((p1, p2) -> Long.compare(p2.getTimestamp(), p1.getTimestamp()))
                .limit(topK)
                .collect(Collectors.toList());
    }
}
