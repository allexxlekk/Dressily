package com.softeng.dressily.entity.closet;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@SuperBuilder(toBuilder = true)
@Entity
@Table(name = "outfit")
public class Outfit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    private String name;

    private String description;

    @ManyToMany()
    private List<Clothing> clothes;
}
