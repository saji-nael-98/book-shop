package com.example.bookshop.base;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
public abstract class BaseEntity {
    protected boolean deleted;
    protected LocalDateTime createdDateTime;
    protected LocalDateTime updatedDateTime;
    protected LocalDateTime deletedDateTime;
}
