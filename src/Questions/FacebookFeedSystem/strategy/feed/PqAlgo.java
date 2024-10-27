package Questions.FacebookFeedSystem.strategy.feed;

import Questions.FacebookFeedSystem.model.Post;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class PqAlgo implements IFeedGenerationAlgoStrategy{
    private final PriorityQueue<Post> pq;

    public PqAlgo() {
        this.pq = new PriorityQueue<>((p1, p2) -> {
            return Long.compare(p1.getTimestamp(), p2.getTimestamp()); // ascending
        });
    }

    @Override
    public List<Post> generateFeed(List<Post> posts, int topK) {
        for(Post post : posts){
            pq.add(post);
            if(pq.size() > topK){
                pq.poll();
            }
        }

        List<Post> feedPosts = new ArrayList<>();
        while (!pq.isEmpty()){
            Post p = pq.poll();
            feedPosts.add(p);
        }
        Collections.reverse(feedPosts);
        return feedPosts;
    }
}
