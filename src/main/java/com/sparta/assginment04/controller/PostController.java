package com.sparta.assginment04.controller;

import com.sparta.assginment04.dto.PostDto;
import com.sparta.assginment04.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;

    @PostMapping("/auth/post")
    public PostDto.DetailResponse createPost(@RequestBody PostDto.Request request) {
        return postService.createPost(request);
    }

    @GetMapping("/post")
    public List<PostDto.SimpleResponse> getPostList() {
        return postService.getPostList();
    }

    @GetMapping("/post/{id}")
    public PostDto.DetailResponse getPost(@PathVariable Long id) {
        return postService.getPost(id);
    }

    @PutMapping("/auth/post/{id}")
    public PostDto.DetailResponse updatePost(@RequestBody PostDto.Request request, @PathVariable Long id) {
        return postService.updatePost(request, id);
    }

    @DeleteMapping("/auth/post/{id}")
    public PostDto.SimpleResponse deletePost(@PathVariable Long id) {
        return postService.deletePost(id);
    }
}
