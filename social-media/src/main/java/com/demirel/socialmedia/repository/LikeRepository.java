package com.demirel.socialmedia.repository;

import com.demirel.socialmedia.model.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Long> {
    List<Like> findByUserIdAndPostIdAndCommentId(Long userId, Long postId, Long commentId);

    List<Like> findByUserId(Long userId);

    List<Like> findByPostId(Long postId);

    List<Like> findByCommentId(Long commentId);
}
