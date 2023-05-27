package com.softeng.dressily.entity.messages;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.softeng.dressily.entity.users.User;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@SuperBuilder(toBuilder = true)
@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @OneToOne()
    private User sender;

    @Column(columnDefinition = "TEXT")
    private String content;

    private String reaction;

    private String timestamp;



}
