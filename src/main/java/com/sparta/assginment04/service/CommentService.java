package com.sparta.assginment04.service;

import com.sparta.assginment04.dto.CommentDto;
import com.sparta.assginment04.model.Comment;
import com.sparta.assginment04.model.Post;
import com.sparta.assginment04.repository.CommentRepository;
import com.sparta.assginment04.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public CommentDto.Response createComment(String text, Long postId) {
        Post post = checkId(postId);
        Comment comment = new Comment(text, post); // 여기서 {}로 묶임
        commentRepository.save(comment);

        return new CommentDto.Response(comment);
    }


    public List<CommentDto.Response> getCommentList(Long postID) {
        // id 체크하고 조회하는 게 나을지 그냥 해도 될지??????????????????????
        List<Comment> commentList = commentRepository.findAllByPostPostId(postID);
        List<CommentDto.Response> responses = new ArrayList<>();

        for (Comment comment : commentList) {
            responses.add(new CommentDto.Response(comment));
        }
        return responses;
    }

    @Transactional
    public CommentDto.Response updateComment(String text, Long postId, Long commentId) {
        Post post = checkId(postId);
        Comment comment = commentRepository.findByPostAndCommentId(post,commentId);
        comment.update(text);
        return new CommentDto.Response(comment);
    }

    public CommentDto.Response deleteComment(Long postId, Long commentId) {
        Post post = checkId(postId);
        Comment comment = commentRepository.findByPostAndCommentId(post, commentId);
        commentRepository.delete(comment);
        return new CommentDto.Response(comment);
    }

    private Post checkId(Long id) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        return post;
    }
}
