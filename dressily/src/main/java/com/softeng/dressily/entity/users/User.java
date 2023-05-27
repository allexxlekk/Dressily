package com.softeng.dressily.entity.users;

import com.softeng.dressily.entity.closet.Closet;
import com.softeng.dressily.entity.closet.Clothing;
import com.softeng.dressily.entity.closet.Outfit;
import com.softeng.dressily.entity.connection.Connection;
import com.softeng.dressily.entity.feed.ExploreFeed;
import com.softeng.dressily.entity.feed.Feed;
import com.softeng.dressily.entity.messages.Chat;
import com.softeng.dressily.entity.post.Post;
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
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @OneToOne(cascade = CascadeType.ALL)
    private Closet closet;

    @OneToOne(cascade = CascadeType.ALL)
    private Connection connection;

    @OneToOne()
    private Profile profile;

    @OneToOne()
    private Feed feed;

    @OneToMany()
    private List<Chat> inbox = new ArrayList<>();

    @OneToOne()
    private ExploreFeed exploreFeed;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Post> posts = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<Notification> notifications = new ArrayList<>();


    public void addClothing(Clothing newClothing){
        closet.getClothes().add(newClothing);
    }
    public void addOutfit(Outfit newOutfit){
        closet.getOutfits().add(newOutfit);
    }
    public void addPost(Post newPost){
        posts.add(newPost);
    }

    public void follow(User user){
        connection.getFollowing().add(user);
    }

    public void acceptFollow(User user){
        connection.getFollowers().add(user);
    }
}
