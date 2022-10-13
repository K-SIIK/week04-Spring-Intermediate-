package com.sparta.assginment04.dto;

import com.sparta.assginment04.model.Comment;
import lombok.Getter;

public class CommentDto {

    @Getter
    public static class Request {
        private String comment;
    }

    @Getter
    public static class Response {
        private final Long commentId;
        private final String text;

        public Response(Comment comment) {
            this.commentId = comment.getCommentId();
            this.text = comment.getText();
        }
    }
}
