package com.bo.post.service;

import com.bo.base.util.Ut;
import com.bo.post.dto.PostDto;
import com.bo.post.entity.Post;
import com.bo.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.*;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public void create(PostDto postDto) {
        postRepository.save(Post.from(postDto));
    }

    public PostDto getById(long postId) {
        return Ut.getObjectElseException(postRepository.findById(postId)).toDto();
    }
}
