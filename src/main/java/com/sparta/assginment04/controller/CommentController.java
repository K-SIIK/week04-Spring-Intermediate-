package com.sparta.assginment04.controller;

import com.sparta.assginment04.dto.CommentDto;
import com.sparta.assginment04.model.Comment;
import com.sparta.assginment04.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/auth/{postId}/comment")
    public CommentDto.Response createComment(@RequestBody String text, @PathVariable Long postId) {
        return commentService.createComment(text, postId);
    }

    @GetMapping("/{postId}/comment")
    public List<CommentDto.Response> getCommentList(@PathVariable Long postId) {
        return commentService.getCommentList(postId);
    }

    @PutMapping("/auth/{postId}/comment/{commentId}")
    public CommentDto.Response updateComment(@RequestBody String text,
                                 @PathVariable Long postId,
                                 @PathVariable Long commentId) {

        return commentService.updateComment(text, postId, commentId);
    }

    @DeleteMapping("/auth/{postId}/comment/{commentId}")
    public CommentDto.Response deleteComment(@PathVariable Long postId,
                                 @PathVariable Long commentId) {

        return commentService.deleteComment(postId, commentId);
    }
}
