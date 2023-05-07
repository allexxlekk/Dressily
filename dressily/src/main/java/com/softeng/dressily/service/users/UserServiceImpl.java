package com.softeng.dressily.service.users;

import com.softeng.dressily.entity.User;
import com.softeng.dressily.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements  UserService{

    private final UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User newUser) {
        // Create new User
        if(newUser.getId() == null)
            return userRepository.save(newUser);

        // Update existing User
        User existingUser = userRepository.findUserById(newUser.getId());
        // Update the new properties
        BeanUtils.copyProperties(newUser, existingUser, "id");
        return userRepository.save(existingUser);
    }
}
