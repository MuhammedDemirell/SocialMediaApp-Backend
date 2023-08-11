package com.demirel.socialmedia.controller;

import com.demirel.socialmedia.model.dto.LikeDto;
import com.demirel.socialmedia.model.request.CreateLikeRequest;
import com.demirel.socialmedia.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/likes")
public class LikeController {

    private final LikeService likeService;
    @GetMapping
    public List<LikeDto> getAllLikes(@RequestParam(required = false) Long userId,
                                     @RequestParam(required = false) Long postId,
                                     @RequestParam(required = false) Long commentId) {
        return likeService.getAllLikes(userId, postId, commentId);
    }
    @GetMapping("/{likeId}")
    public LikeDto getOneLike(@PathVariable Long likeId) {
        return likeService.getOneLikeById(likeId);
    }
    @PostMapping
    public CreateLikeRequest createLike(@RequestBody CreateLikeRequest createLikeRequest) {
        return likeService.createLike(createLikeRequest);
    }
    @DeleteMapping("/{likeId}")
    public void deleteLikeById(@PathVariable Long likeId) {
        likeService.deleteLikeById(likeId);
    }
}
