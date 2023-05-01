package com.bo.post;

import com.bo.post.dto.PostDto;
import com.bo.post.entity.Post;
import com.bo.post.repository.PostRepository;
import com.bo.post.service.PostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PostServiceTests {
    @Mock
    private PostRepository postRepository;
    @InjectMocks
    private PostService postService;

    @BeforeEach
    void initData() {
        Post post = Post.from(
                PostDto.builder()
                        .title("title1")
                        .content("content1")
                        .build()
        );
    };
}
