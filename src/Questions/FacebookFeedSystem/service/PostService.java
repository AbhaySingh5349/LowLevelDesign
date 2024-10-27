package Questions.FacebookFeedSystem.service;

import Questions.FacebookFeedSystem.model.Post;
import Questions.FacebookFeedSystem.repository.IPostRepo;

import java.util.List;

public class PostService {
    private final IPostRepo postRepo;

    public PostService(IPostRepo postRepo) {
        this.postRepo = postRepo;
    }

    public void add(Post post){
        postRepo.add(post);
    }

    public void delete(String postId){
        postRepo.delete(postId);
    }

    public Post getPostById(String postId){
        return postRepo.getPostById(postId);
    }

    public List<Post> getAllPosts(){
        return postRepo.getAllPosts();
    }

    public List<Post> getPostsByUserId(String userId){
        return postRepo.getPostsByUserId(userId);
    }
}
