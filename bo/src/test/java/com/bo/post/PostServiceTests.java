package com.bo.post;

import com.bo.post.dto.PostDto;
import com.bo.post.entity.Post;
import com.bo.post.repository.PostRepository;
import com.bo.post.service.PostService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PostServiceTests {
    @Mock
    private PostRepository postRepository;
    @InjectMocks
    private PostService postService;

    private PostDto initData(int num) {
        return PostDto.builder()
                .title("title%d".formatted(num))
                .content("content%d".formatted(num))
                .build();
    }
    private List<PostDto> initDatas(int size) {
        List<PostDto> postDtos = new ArrayList<>();

        for(int i = 1; i <= size; i++) {
            postDtos.add(initData(i));
        }
        return postDtos;
    }

    @DisplayName("create Post, then get Post by postId")
    @Test
    void test1() {
        //given
        PostDto postDto = initData(1);

        //when
        postService.create(postDto);
        when(postRepository.findById(any())).thenReturn(Optional.of(Post.from(postDto)));
        PostDto resultDto = postService.getById(1L);

        //then
        assertThat(resultDto.getTitle()).isEqualTo("title1");
        assertThat(resultDto.getContent()).isEqualTo("content1");
    }

    @DisplayName("get post by author")
    @Test
    void test2() {
        //given

        //when

        //then
    }

    @DisplayName("modify post")
    @Test
    void test3() {
        //given
        PostDto postDto = initData(1);
        when(postRepository.findById(any())).thenReturn(Optional.of(Post.from(postDto)));
        postService.create(postDto);
        PostDto resultDto = postService.getById(1L);

        assertThat(resultDto.getTitle()).isEqualTo("title1");
        assertThat(resultDto.getContent()).isEqualTo("content1");
        assertThat(resultDto.getRecordLog().getUpdatedDateTime()).isNull();

        //when
        PostDto updatedDto = PostDto.builder()
                .title("updated title")
                .content("updated content")
                .build();
        when(postRepository.findById(any())).thenReturn(Optional.of(Post.from(updatedDto)));
        postService.update(updatedDto);
        resultDto = postService.getById(1L);

        //then
        assertThat(resultDto.getTitle()).isEqualTo("updated title");
        assertThat(resultDto.getContent()).isEqualTo("updated content");
        assertThat(resultDto.getRecordLog().getUpdatedDateTime()).isNotNull();
    }
    @DisplayName("delete post")
    @Test
    void test4() {
        //given
        List<PostDto> postDtos = initDatas(3);
        //when
        when(postService.findAll()).then(postDtos);
        when(postService.delete(0L)).then(postDtos.remove(0));

        postService.delete(0L);
        postDtos = postService.getAll();

        //then
        assertThat(postDtos.size()).isEqualTo(2);
    }
}
