package com.softeng.dressily.repository;

import com.softeng.dressily.entity.closet.Clothing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClothingRepository extends JpaRepository<Clothing, Long> {

    Clothing findClothingById(Long id);
}
