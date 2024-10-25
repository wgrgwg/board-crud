package com.project.board.service;

import com.project.board.model.Board;
import com.project.board.model.Post;
import com.project.board.repository.PostRepository;
import java.time.LocalDateTime;
import java.util.List;

public final class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void addPost(Board board, String title, String content) {
        Post post = new Post(board, title, content);
        postRepository.addPost(post);
    }

    public Post findPostById(int id) {
        return postRepository.findPostById(id);
    }

    public List<Post> getAllPosts() {
        return postRepository.getAllPosts();
    }

    public boolean updatePost(int id, String newTitle, String newContent) {
        Post post = postRepository.findPostById(id);
        if (post != null) {
            post.setTitle(newTitle);
            post.setContent(newContent);
            post.setEditedDateTime(LocalDateTime.now());
            return true;
        }
        return false;
    }

    public boolean deletePostById(int id) {
        return postRepository.deletePostById(id);
    }

    public boolean validatePostIdExists(int id) {
        return postRepository.findPostById(id) != null;
    }
}
