package com.softeng.dressily.entity.closet;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@SuperBuilder(toBuilder = true)
@Entity
@Table(name = "closet")
public class Closet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Outfit> outfits = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<Clothing> clothes = new ArrayList<>();
}
