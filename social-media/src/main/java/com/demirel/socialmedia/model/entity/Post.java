package com.demirel.socialmedia.model.entity;


import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import static com.demirel.socialmedia.util.CommonConstants.SYSTEM.ZONE_ID;

@Entity
@Table(name = "posts")
@Getter
@Setter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(length = 250, nullable = false)
    private String title;

    @Lob
    @Column(columnDefinition = "text", nullable = false)
    private String text;

    @Column(nullable = false)
    private final LocalDateTime createdDate = LocalDateTime.now(ZONE_ID);

    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Like> likes;

    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Comment> comments;

}
