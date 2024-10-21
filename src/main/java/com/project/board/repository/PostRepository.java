package com.project.board.repository;

import com.project.board.model.Post;
import java.util.ArrayList;
import java.util.List;

public final class PostRepository {
    private List<Post> posts = new ArrayList<>();

    public void addPost(Post post){
        posts.add(post);
    }

    public Post findPostById(int id){
        for(Post post : posts){
            if(post.getId() == id){
                return post;
            }
        }

        return null;
    }

    public boolean deletePostById(int id){
        for(Post post : posts){
            if(post.getId() == id){
                posts.remove(post);
                return true;
            }
        }

        return false;
    }

    public List<Post> getAllPosts(){
        return posts;
    }
}
