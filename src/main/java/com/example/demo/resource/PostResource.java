package com.example.demo.resource;

import com.example.demo.models.Post;
import com.example.demo.services.PostServices;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostResource {
    private final PostServices postServices;

    @GetMapping("")
    public ResponseEntity<List<Post>> getAllPosts() {
        return ResponseEntity.ok(postServices.getAllPosts());
    }

    // post
    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(
            @PathVariable Long id) {
        return ResponseEntity.ok(postServices.getPostById(id));
    }


    @PostMapping("")
    public ResponseEntity<Post> addPost(
            @RequestBody Post post) {
        postServices.addPost(post);
        return ResponseEntity.ok(post);
    }


}
