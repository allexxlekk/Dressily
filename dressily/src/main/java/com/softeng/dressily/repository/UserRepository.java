package com.softeng.dressily.repository;

import com.softeng.dressily.entity.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findUserById(Long Id);
}
