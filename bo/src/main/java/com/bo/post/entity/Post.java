package com.bo.post.entity;

import com.bo.base.dto.RecordLog;
import com.bo.post.dto.PostDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postNo;
    @Column(nullable = false)
    private String title;
    @Column(columnDefinition = "LONGTEXT")
    private String content;
    @Embedded
    private RecordLog recordLog;

    public static Post from(PostDto postDto) {
        return Post.builder()
                .title(postDto.getTitle())
                .content(postDto.getContent())
                .recordLog(postDto.getRecordLog())
                .build();
    }
//    private Member author;
//    private Category category;
}
