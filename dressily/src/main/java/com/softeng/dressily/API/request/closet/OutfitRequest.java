package com.softeng.dressily.API.request.closet;

import lombok.*;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Getter
@Setter
public class OutfitRequest {

    private Long id;

    private String name;

    private String description;

    private List<Long> clothingIdList;
}
