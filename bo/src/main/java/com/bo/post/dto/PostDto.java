package com.bo.post.dto;

import com.bo.base.dto.RecordLog;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostDto {
    private Long postNo;
    private String title;
    private String content;
    private RecordLog recordLog;
}
