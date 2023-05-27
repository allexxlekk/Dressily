package com.softeng.dressily.entity.connection;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.softeng.dressily.entity.users.User;
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
@Table(name = "connection")
public class Connection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @OneToMany()
    private List<User> following = new ArrayList<>();

    @OneToMany()
    private List<User> followers = new ArrayList<>();
}
