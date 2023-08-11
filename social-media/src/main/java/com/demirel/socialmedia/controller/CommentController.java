package com.demirel.socialmedia.controller;

import com.demirel.socialmedia.model.dto.CommentDto;
import com.demirel.socialmedia.model.request.CreateCommentRequest;
import com.demirel.socialmedia.model.request.UpdateCommentRequest;
import com.demirel.socialmedia.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping
    public List<CommentDto> getAllComments(@RequestParam(required = false) Long userId,
                                           @RequestParam(required = false) Long postId) {
        return commentService.getAllComments(userId, postId);
    }
    @PostMapping
    public CreateCommentRequest createComment(@RequestBody CreateCommentRequest createCommentRequest) {
        return commentService.createComment(createCommentRequest);
    }
    @PutMapping("/{commentId}")
    public UpdateCommentRequest updateComment(@PathVariable Long commentId, @RequestBody UpdateCommentRequest updateCommentRequest) {
        return commentService.updateComment(commentId, updateCommentRequest);
    }
    @GetMapping("/delete")
    public void deleteOneCommentById(Long commentId) {
        commentService.deleteById(commentId);
    }
}
