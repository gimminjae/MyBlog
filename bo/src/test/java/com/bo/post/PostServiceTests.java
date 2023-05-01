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
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PostServiceTests {
    @Mock
    private PostRepository postRepository;
    @InjectMocks
    private PostService postService;

    private PostDto initData(String title, String content) {
        return PostDto.builder()
                        .title(title)
                        .content(content)
                        .build();
    }
    @DisplayName("create Post, then get Post")
    @Test
    void test1() {
        //given
        PostDto postDto = initData("title1", "content1");

        //when
        postService.create(postDto);
        when(postService.getById(1L).getTitle()).doReturn(postDto);
        PostDto resultDto = postService.getById(1L);

        //then
        assertThat(resultDto.getTitle()).isEqualTo("title1");
        assertThat(resultDto.getContent()).isEqualTo("content1");
    }
}
