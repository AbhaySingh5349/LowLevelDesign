package Questions.FacebookFeedSystem.repository;

import Questions.FacebookFeedSystem.model.Post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InMemoryPostRepo implements IPostRepo{
    private final Map<String, Post> postMap;

    public InMemoryPostRepo() {
        this.postMap = new HashMap<>();
    }

    @Override
    public void add(Post post) {
        String id = post.getId();
        postMap.put(id, post);
    }

    @Override
    public void delete(String postId) {
        postMap.remove(postId);
    }

    @Override
    public Post getPostById(String postId) {
        return postMap.get(postId);
    }

    @Override
    public List<Post> getAllPosts() {
        return new ArrayList<>(postMap.values());
    }

    @Override
    public List<Post> getPostsByUserId(String userId) {
        List<Post> posts = getAllPosts();
        return posts.stream().filter(post -> post.getUserId().equals(userId)).collect(Collectors.toList());
    }
}
