package com.bo.base.dto;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Embeddable
@Data
@NoArgsConstructor
public class RecordLog {
    private LocalDateTime createdDateTime;
    private LocalDateTime updatedDateTime;
    public RecordLog(LocalDateTime createdDateTime, LocalDateTime updatedDateTime) {
        this.createdDateTime = createdDateTime;
        this.updatedDateTime = updatedDateTime;
    }
    public RecordLog(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }
}
