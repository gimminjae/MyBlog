package com.bo.base.dto;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Embeddable
@Data
public class RecordLog {
    private LocalDateTime createdDateTime;
    private LocalDateTime updatedDateTime;
}
