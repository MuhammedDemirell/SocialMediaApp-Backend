package com.demirel.socialmedia.model.entity;


import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

import static com.demirel.socialmedia.util.CommonConstants.SYSTEM.ZONE_ID;
import static javax.persistence.CascadeType.REMOVE;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "posts")
@Getter
@Setter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(length = 250, nullable = false)
    private String title;

    @Column(columnDefinition = "text", nullable = false , length = 10000)
    private String text;

    @Column(nullable = false)
    private final LocalDateTime createdDate = LocalDateTime.now(ZONE_ID);

    @OneToMany(mappedBy = "post", cascade = REMOVE, fetch = EAGER)
    private Set<Like> likes;

    @OneToMany(mappedBy = "post", cascade = REMOVE, fetch = EAGER)
    private Set<Comment> comments;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
