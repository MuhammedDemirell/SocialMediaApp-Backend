package com.demirel.socialmedia.repository;

import com.demirel.socialmedia.model.entity.Post;
import com.demirel.socialmedia.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
