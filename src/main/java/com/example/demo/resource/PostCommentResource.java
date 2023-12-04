package com.example.demo.resource;

import com.example.demo.dto.PostCommentDTO;
import com.example.demo.response.DataResponse;
import com.example.demo.services.PostCommentServices;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/postCmt")
@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostCommentResource {
    private  PostCommentServices postCommentServices;


    @PostMapping()
    public ResponseEntity<DataResponse<PostCommentDTO>> addPostComment(@RequestBody PostCommentDTO postCommentDTO) {
        System.out.println(postCommentDTO);
        postCommentServices.addPostComment(postCommentDTO.getPostId(), postCommentDTO.getPostComment().getUser().getId(),
                postCommentDTO.getPostComment());
        return ResponseEntity.ok(DataResponse.<PostCommentDTO>builder()
                .data(postCommentDTO)
                .message("Post comment added successfully")
                .status(200)
                .build());
    }

}
