package com.bo.post.service;

import com.bo.base.util.Ut;
import com.bo.post.dto.PostDto;
import com.bo.post.entity.Post;
import com.bo.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;

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

    public void update(PostDto updatedDto) {
        Post post = Ut.getObjectElseException(postRepository.findById(updatedDto.getPostId()));

        post.update(updatedDto);

        postRepository.save(post);
    }
    public List<PostDto> getAll() {
        return postRepository.findAll().stream().map(Post::toDto).toList();
    }
    public void delete(long postId) {
        postRepository.delete(Ut.getObjectElseException(postRepository.findById(postId)));
    }
}
