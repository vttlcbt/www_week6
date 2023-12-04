package com.example.demo.dto;

import com.example.demo.models.PostComment;
import lombok.Data;

@Data
public class PostCommentDTO {
    private String postId;
    private PostComment postComment;

    public PostCommentDTO(String postId, PostComment postComment) {
        this.postId = postId;
        this.postComment = postComment;
    }
}
