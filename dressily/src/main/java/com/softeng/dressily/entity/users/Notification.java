package com.softeng.dressily.entity.users;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;


@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
@SuperBuilder(toBuilder = true)
@Entity
@Table(name = "notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    private String content;

    private String type;

    @ManyToOne()
    @JsonIgnore
    private User fromUser;


}
