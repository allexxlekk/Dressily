package com.softeng.dressily.controller;

import com.softeng.dressily.entity.messages.Chat;
import com.softeng.dressily.entity.post.Post;
import com.softeng.dressily.entity.users.User;
import com.softeng.dressily.service.users.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/dressily/users")
@RequiredArgsConstructor
@Log4j2
public class UsersController {

    private final UserService userService;
    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping()
    public User createUser(@RequestBody User newUser){
        return userService.createUser(newUser);
    }

    @PostMapping("/populate")
    public List<User> createManyUsers(@RequestBody List<User> newUsers){
        return newUsers.stream().map(userService::createUser).toList();
    }

    @GetMapping("{userID}/follow/{followingID}")
    public void followUser(@PathVariable Long userID, @PathVariable Long followingID){
        userService.followUser(userID, followingID);
    }

    @GetMapping("{userID}/feed")
    public List<Post> getFeed(@PathVariable Long userID, @RequestParam Boolean explore){
        return userService.feed(userID, explore);
    }

    @PostMapping("{fromUserID}/message/{toUserID}")
    public void message(@PathVariable Long fromUserID, @PathVariable Long toUserID, @RequestBody String message){
         userService.message(fromUserID, toUserID, message);
    }
}
