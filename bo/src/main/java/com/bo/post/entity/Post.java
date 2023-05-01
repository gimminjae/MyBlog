package com.bo.post.entity;

import com.bo.base.dto.RecordLog;
import com.bo.post.dto.PostDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
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
                .recordLog(new RecordLog(LocalDateTime.now()))
                .build();
    }

    public PostDto toDto() {
        return PostDto.builder()
                .postId(this.getPostId())
                .recordLog(this.getRecordLog())
                .title(this.getTitle())
                .content(this.getContent())
                .build();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setRecordLog(RecordLog recordLog) {
        this.recordLog = recordLog;
    }

    public void update(PostDto updatedDto) {
        this.setTitle(updatedDto.getTitle());
        this.setContent(updatedDto.getContent());
        this.setRecordLog(
                new RecordLog(
                        this.getRecordLog().getCreatedDateTime(),
                        LocalDateTime.now()
                )
        );
    }
//    private Member author;
//    private Category category;
}
