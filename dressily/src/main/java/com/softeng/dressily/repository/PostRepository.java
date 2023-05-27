package com.softeng.dressily.repository;

import com.softeng.dressily.entity.closet.Clothing;
import com.softeng.dressily.entity.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    Post findPostById(Long id);
}
