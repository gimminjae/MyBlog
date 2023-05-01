package com.bo.post.entity;

import com.bo.base.dto.RecordLog;
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
//    private Member author;
//    private Category category;
}
