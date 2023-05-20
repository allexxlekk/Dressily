package com.softeng.dressily.controller;

import com.softeng.dressily.API.request.closet.OutfitRequest;
import com.softeng.dressily.entity.closet.Closet;
import com.softeng.dressily.entity.closet.Clothing;
import com.softeng.dressily.entity.closet.Outfit;
import com.softeng.dressily.service.users.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/dressily/closet")
@RequiredArgsConstructor
@Log4j2
public class ClosetController {

    final private UserService userService;

    @PostMapping("/{userId}/addClothing")
    public Closet addClothing(
            @PathVariable Long userId,
            @RequestBody Clothing newClothing
    ){
        return userService.addClothing(userId, newClothing);
    }

    @PostMapping("/{userId}/addOutfit")
    public Closet addOutfit(
            @PathVariable Long userId,
            @RequestBody OutfitRequest outfitRequest
            ){

        return userService.addOutfit(userId, outfitRequest);
    }
}
