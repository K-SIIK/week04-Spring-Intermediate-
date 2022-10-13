package com.sparta.assginment04.service;

import com.sparta.assginment04.dto.PostDto;
import com.sparta.assginment04.model.Comment;
import com.sparta.assginment04.model.Post;
import com.sparta.assginment04.repository.CommentRepository;
import com.sparta.assginment04.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public PostDto.DetailResponse createPost(PostDto.Request request) {
        Post post = new Post(request);

        postRepository.save(post);

        return new PostDto.DetailResponse(post);
    }

    public List<PostDto.SimpleResponse> getPostList() {
        List<Post> posts = postRepository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
        if (posts.isEmpty()) throw new NullPointerException("게시물이 존재하지 않습니다.");
        List<PostDto.SimpleResponse> responses = new ArrayList<>();
        for (Post post : posts) {
            responses.add(new PostDto.SimpleResponse(post));
        }
        return responses;
    }


    public PostDto.DetailResponse getPost(Long id) {
        Post post = checkId(id);
        return new PostDto.DetailResponse(post);

    }

    @Transactional
    public PostDto.DetailResponse updatePost(PostDto.Request request, Long id) {
        Post post = checkId(id);
        post.update(request);
        return new PostDto.DetailResponse(post);
    }


    public PostDto.SimpleResponse deletePost(Long id) {
        Post post = checkId(id);
        postRepository.delete(post);
        return new PostDto.SimpleResponse(post);
    }


    private Post checkId(Long id) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        return post;
    }

}
