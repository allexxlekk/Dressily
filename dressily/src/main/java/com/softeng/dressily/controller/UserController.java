package com.softeng.dressily.controller;


import com.softeng.dressily.domain.User;
import com.softeng.dressily.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Log4j2
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/all")
    public User getAllUsers(){
        User u1 = User
                .builder()
                .name("xari")
                .build();

        return u1;
    }

}
