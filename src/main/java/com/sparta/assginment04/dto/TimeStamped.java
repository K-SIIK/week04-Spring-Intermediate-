package com.sparta.assginment04.dto;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // 상속했을 때 이 클래스의 멤버가 테이블의 column 으로 들어감
@EntityListeners(AuditingEntityListener.class)// 변경되었을 때 자동으로 기록
public class TimeStamped {

    @CreatedDate // 생성 시간
    private LocalDateTime createdAt;

    @LastModifiedDate // 마지막 변경 시간
    private LocalDateTime updatedAt;


}
