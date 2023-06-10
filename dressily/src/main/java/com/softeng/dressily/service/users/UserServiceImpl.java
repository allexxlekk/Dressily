package com.softeng.dressily.service.users;

import com.softeng.dressily.API.request.closet.OutfitRequest;
import com.softeng.dressily.entity.closet.Closet;
import com.softeng.dressily.entity.closet.Clothing;
import com.softeng.dressily.entity.closet.Outfit;
import com.softeng.dressily.entity.messages.Chat;
import com.softeng.dressily.entity.post.Comment;
import com.softeng.dressily.entity.post.Post;
import com.softeng.dressily.entity.users.Notification;
import com.softeng.dressily.entity.users.User;
import com.softeng.dressily.repository.ClothingRepository;
import com.softeng.dressily.repository.PostRepository;
import com.softeng.dressily.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements  UserService{

    private final UserRepository userRepository;
    private final ClothingRepository clothingRepository;
    private final PostRepository postRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User createUser(User newUser) {
        // Create new User
        if(newUser.getId() == null)
            return userRepository.save(newUser);

        // Update existing User
        User existingUser = userRepository.findUserById(newUser.getId());
        // Update properties
        existingUser.setUsername(newUser.getUsername());

        return userRepository.save(existingUser);
    }

    @Override
    @Transactional
    public Closet addClothing(Long userId, Clothing newClothing) {
        User user = userRepository.findUserById(userId);
        user.addClothing(newClothing);
        return userRepository.save(user).getCloset();
    }

    @Override
    @Transactional
    public List<Post> addPost(Long userId, Post newPost) {
        User user = userRepository.findUserById(userId);
        user.addPost(newPost);
        return userRepository.save(user).getPosts();
    }

    @Override
    @Transactional
    public Post likePost(Long postId) {
        Post post = postRepository.findPostById(postId);
        post.like();
        return postRepository.save(post);
    }

    public Closet addOutfit(Long userId, OutfitRequest outfitRequest) {
        User user = userRepository.findUserById(userId);
        Outfit newOutfit = Outfit
                .builder()
                .name(outfitRequest.getName())
                .description(outfitRequest.getDescription())
                .build();

        newOutfit.setClothes(outfitRequest.getClothingIdList()
                .stream()
                .map(clothingRepository::findClothingById)
                .toList());

        user.addOutfit(newOutfit);
        return userRepository.save(user).getCloset();
    }

    @Override
    @Transactional
    public void followUser(Long userId, Long followingId) {
        User user = userRepository.findUserById(userId);
        User following = userRepository.findUserById(followingId);

        user.follow(following);
        following.acceptFollow(user);
        following.newNotification(
                new Notification()
                        .toBuilder()
                        .type("follow")
                        .content(user.getUsername() +" started following you")
                        .build()
        );

        userRepository.save(user);
        userRepository.save(following);
    }

    @Override
    public List<Post> feed(Long userId, Boolean explore) {
        List<Post> posts = new ArrayList<>();
        List<User> users = new ArrayList<>();
        if(explore)
            users = userRepository.findAll();
        else
            users = userRepository.findUserById(userId).getConnection().getFollowing();
        for(User u : users)
            posts.addAll(u.getPosts());
        return posts;
    }

    @Override
    @Transactional
    public Post commentPost(Long userId, Long postID, Comment newComment) {
        Post post = postRepository.findPostById(postID);
        newComment.setAuthor(userRepository.findUserById(userId).getUsername());
        post.getComments().add(newComment);
        return postRepository.save(post);
    }

    @Override
    @Transactional
    public void message(Long userID, Long toUserId, String message) {
        Notification messageNotification = new Notification()
                .toBuilder()
                .type("follow")
                .content(userRepository.findUserById(userID).getUsername() +": " + message)
                .build();
        User toUser = userRepository.findUserById(toUserId);
        toUser.getNotifications().add(messageNotification);
        userRepository.save(toUser);
    }
}
