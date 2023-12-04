package com.example.demo.services;

import com.example.demo.models.Post;
import com.example.demo.models.PostComment;
import com.example.demo.models.User;
import com.example.demo.repositories.PostCommentRepository;
import com.example.demo.repositories.PostRepository;
import com.example.demo.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PostCommentServices {

    private final PostCommentRepository postCommentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public void addPostComment(String postId, Long userId, PostComment postComment) {
        Optional<User> user = (userRepository.findUserById(userId));
        Optional<Post> post = postRepository.findById(Long.parseLong(postId));

        if (user.isEmpty() || post.isEmpty()) {
            throw new RuntimeException("User or Post not found");
        }
        postComment.setPost(post.get());
        postCommentRepository.save(postComment);
    }
}
