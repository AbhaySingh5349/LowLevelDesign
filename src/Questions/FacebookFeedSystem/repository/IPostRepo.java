package Questions.FacebookFeedSystem.repository;

import Questions.FacebookFeedSystem.model.Post;

import java.util.List;

public interface IPostRepo {
    void add(Post post);
    void delete(String postId);
    Post getPostById(String postId);
    List<Post> getAllPosts();
    List<Post> getPostsByUserId(String userId);
}
