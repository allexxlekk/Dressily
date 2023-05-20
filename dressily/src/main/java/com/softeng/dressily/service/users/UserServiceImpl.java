package com.softeng.dressily.service.users;

import com.softeng.dressily.API.request.closet.OutfitRequest;
import com.softeng.dressily.entity.closet.Closet;
import com.softeng.dressily.entity.closet.Clothing;
import com.softeng.dressily.entity.closet.Outfit;
import com.softeng.dressily.entity.users.User;
import com.softeng.dressily.repository.ClothingRepository;
import com.softeng.dressily.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements  UserService{

    private final UserRepository userRepository;
    private final ClothingRepository clothingRepository;

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
        existingUser.setName(newUser.getName());

        return userRepository.save(existingUser);
    }

    @Override
    @Transactional
    public Closet addClothing(Long userId, Clothing newClothing) {
        User user = userRepository.findUserById(userId);
        user.getCloset().getClothes().add(newClothing);
        return userRepository.save(user).getCloset();
    }

    @Override
    @Transactional
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

        user.getCloset().getOutfits().add(newOutfit);
        return userRepository.save(user).getCloset();
    }
}
