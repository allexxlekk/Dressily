package com.softeng.dressily.service.users;

import com.softeng.dressily.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User createUser(User newUser);
}
