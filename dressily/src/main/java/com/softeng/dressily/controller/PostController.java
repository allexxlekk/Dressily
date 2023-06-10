package com.softeng.dressily.controller;

import com.softeng.dressily.entity.post.Comment;
import com.softeng.dressily.entity.post.Post;
import com.softeng.dressily.service.users.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/dressily/posts")
@RequiredArgsConstructor
@Log4j2
public class PostController {
    private final UserService userService;
    @PostMapping("/{userId}/addPost")
    public List<Post> addPost(@PathVariable Long userId, @RequestBody Post newPost){
        return userService.addPost(userId, newPost);
    }
    @PostMapping("/{userId}/comment/{postId}")
    public Post addPost(@PathVariable Long userId,@PathVariable Long postId, @RequestBody Comment newComment){
        return userService.commentPost(userId, postId, newComment);
    }
    @GetMapping("/{postId}/likePost")
    public Post likePost(@PathVariable Long postId){
        return userService.likePost(postId);
    }
}
