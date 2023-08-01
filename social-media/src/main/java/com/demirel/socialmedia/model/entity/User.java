package com.demirel.socialmedia.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(length = 25, nullable = false)
        private String userName;

        @Column(length = 25, nullable = false)
        private String password;

        @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
        private List<Post> posts;

        @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
        private List<Like> likes;

        @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
        private List<Comment> comments;

        @Column(nullable = false)
        private int avatar;

}

