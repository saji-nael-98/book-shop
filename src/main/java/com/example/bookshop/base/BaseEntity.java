package com.example.bookshop.base;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
public abstract class BaseEntity {
    protected boolean deleted;
    @Column(updatable = false)
    protected LocalDateTime createdDateTime;
    protected LocalDateTime updatedDateTime;
    protected LocalDateTime deletedDateTime;
}
