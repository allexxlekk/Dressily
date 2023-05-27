package com.softeng.dressily.entity.post;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.softeng.dressily.entity.closet.Outfit;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@SuperBuilder(toBuilder = true)
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    private String author;

    @Column(columnDefinition = "TEXT")
    private String text;

    @OneToOne
    private Outfit outfit;
}
