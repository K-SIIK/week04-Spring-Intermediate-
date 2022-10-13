package com.sparta.assginment04.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparta.assginment04.dto.PostDto;
import com.sparta.assginment04.dto.TimeStamped;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class Post extends TimeStamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long postId;

    @Column(nullable = false, unique = true)
    private String nickName;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @JsonIgnore
    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    private List<Comment> commentList;

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public Post(PostDto.Request request) {
        this.nickName = request.getNickName();
        this.title = request.getTitle();
        this.content = request.getContent();
    }

    public void update(PostDto.Request request) {
        this.nickName = request.getNickName();
        this.title = request.getTitle();
        this.content = request.getContent();
    }


}
