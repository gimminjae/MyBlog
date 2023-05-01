package com.bo.post;

import com.bo.post.dto.PostDto;
import com.bo.post.entity.Post;
import com.bo.post.repository.PostRepository;
import com.bo.post.service.PostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.anyOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PostServiceTests {
    @Mock
    private PostRepository postRepository;
    @InjectMocks
    private PostService postService;

    private PostDto initData() {
        return PostDto.builder()
                        .title("title1")
                        .content("content1")
                        .build();
    }
    @DisplayName("create Post, then get Post by postId")
    @Test
    void test1() {
        //given
        PostDto postDto = initData();

        //when
        postService.create(postDto);
        when(postRepository.findById(any())).thenReturn(Optional.of(Post.from(postDto)));
        PostDto resultDto = postService.getById(1L);

        //then
        assertThat(resultDto.getTitle()).isEqualTo("title1");
        assertThat(resultDto.getContent()).isEqualTo("content1");
    }
}
