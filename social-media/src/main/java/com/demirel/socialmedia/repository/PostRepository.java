package com.demirel.socialmedia.repository;

import com.demirel.socialmedia.model.dto.PostDto;
import com.demirel.socialmedia.model.entity.Post;
import com.demirel.socialmedia.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {


    List<Post> findByUserId(Long userId);

}
