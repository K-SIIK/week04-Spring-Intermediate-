package com.sparta.assginment04.dto;

import com.sparta.assginment04.model.Comment;
import com.sparta.assginment04.model.Post;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

public class PostDto {

    @Getter
    public static class Request {
        private String nickName;
        private String title;
        private String content;
    }

    @Getter
    public static class SimpleResponse {
        private final String nickname;
        private final String title;
        private final LocalDateTime createdAt;

        public SimpleResponse(Post post) {
            this.nickname = post.getNickName();
            this.title = post.getTitle();
            this.createdAt = post.getCreatedAt();
        }
    }

    @Getter
    public static class DetailResponse {
        private final Long postId;
        private final String nickname;
        private final String title;
        private final String content;
        private List<Comment> commentList;
        private final LocalDateTime createdAt;

        public DetailResponse(Post post) {
            this.postId = post.getPostId();
            this.nickname = post.getNickName();
            this.title = post.getTitle();
            this.content = post.getContent();
            this.commentList = post.getCommentList();
            this.createdAt = post.getCreatedAt();
        }
    }
}
