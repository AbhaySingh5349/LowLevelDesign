package Questions.FacebookFeedSystem.model;

import Questions.FacebookFeedSystem.strategy.content.IPostContent;

public class Post {
    private final String id;
    private final String userId;
    private final IPostContent postContent;
    private final long timestamp;

    public Post(String id, String userId, IPostContent postContent) {
        this.id = id;
        this.userId = userId;
        this.postContent = postContent;
        this.timestamp = System.nanoTime();
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getPostContent() {
        return postContent.getContent();
    }

    public long getTimestamp() {
        return timestamp;
    }
}
