package com.softeng.dressily.entity.messages;

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
@Table(name = "chat")
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    private String fromUser;

    private String chatName;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Message> messages =  new ArrayList<>();
}
