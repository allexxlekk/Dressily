package com.softeng.dressily.service.users;

import com.softeng.dressily.API.request.closet.OutfitRequest;
import com.softeng.dressily.entity.closet.Closet;
import com.softeng.dressily.entity.closet.Clothing;
import com.softeng.dressily.entity.post.Post;
import com.softeng.dressily.entity.users.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User createUser(User newUser);

    Closet addClothing(Long userId, Clothing newClothing);

    List<Post> addPost(Long userId, Post newPost);
    Post likePost(Long postId);

    Closet addOutfit(Long userId, OutfitRequest outfitRequest);
}
