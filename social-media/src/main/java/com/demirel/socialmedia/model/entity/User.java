package com.demirel.socialmedia.model.entity;

import lombok.*;

import javax.persistence.*;

import java.util.Objects;
import java.util.Set;

import static javax.persistence.CascadeType.REMOVE;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;


@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 25, nullable = false)
    private String userName;

    @Column(length = 25, nullable = false)
    private String password;

    @OneToMany(mappedBy = "user", cascade = REMOVE, fetch = EAGER)
    private Set<Post> posts;

    @OneToMany(mappedBy = "user", cascade = REMOVE, fetch = EAGER)
    private Set<Like> likes;

    @OneToMany(mappedBy = "user", cascade = REMOVE, fetch = EAGER)
    private Set<Comment> comments;

    @Column(nullable = false)
    private int avatar;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

