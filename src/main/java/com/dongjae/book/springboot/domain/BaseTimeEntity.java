package com.dongjae.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass //JPA ENTITY 클래스들이 BASETIMEENTITY를 상속할 경우 필드들도 칼럼으로 인식
@EntityListeners(AuditingEntityListener.class) //BASETIMEENTITY에 Auditing 기능 포함
public abstract class BaseTimeEntity {
    @CreatedDate // 시간 자동저장
    private LocalDateTime createDate;

    @LastModifiedDate //수정 자동저장
    private LocalDateTime modifiedDate;
}
