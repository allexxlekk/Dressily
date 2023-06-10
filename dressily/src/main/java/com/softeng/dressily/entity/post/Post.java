package com.softeng.dressily.entity.post;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.softeng.dressily.entity.users.User;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.engine.internal.Cascade;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@SuperBuilder(toBuilder = true)
@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String text;

    private String timestamp;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    private Integer totalLikes = 0;

    public void like(){
        totalLikes += 1;
    }
}
