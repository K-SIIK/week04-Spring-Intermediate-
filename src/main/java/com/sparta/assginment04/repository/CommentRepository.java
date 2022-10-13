package com.sparta.assginment04.repository;

import com.sparta.assginment04.model.Comment;
import com.sparta.assginment04.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    Comment findByPostAndCommentId(Post post, Long id);
    List<Comment> findAllByPostPostId(Long postID);

}
