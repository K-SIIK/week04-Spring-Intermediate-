package com.sparta.assginment04.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Comment {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long commentId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "POST_KEY", nullable = false)
    private Post post;

    @Column(nullable = false)
    private String text;

    public Comment(String text, Post post) {
        this.post = post;
        this.text = text;
    }

    public void update(String text) {
        this.text = text;
    }
}
