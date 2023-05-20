package com.softeng.dressily.entity.users;

import com.softeng.dressily.entity.closet.Closet;
import com.softeng.dressily.entity.closet.Clothing;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@SuperBuilder(toBuilder = true)
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private Closet closet;


    public void addClothing(Clothing newClothing){
        closet.getClothes().add(newClothing);
    }
}
