package com.datasite.project.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class TimeStamped {
    @CreatedDate
    @Column(updatable = false)
    private LocalTime createdTime;

    @CreatedDate
    @Column(updatable = false)
    private LocalDate createdDate;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;
}
