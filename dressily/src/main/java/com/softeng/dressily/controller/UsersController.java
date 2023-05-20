package com.softeng.dressily.controller;

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

}
