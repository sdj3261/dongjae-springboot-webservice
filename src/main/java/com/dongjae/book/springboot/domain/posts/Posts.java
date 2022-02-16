package com.dongjae.book.springboot.domain.posts;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
/*
롬북에서 제공하는 어노테이션으로 코드 단순화 목적
 */
@Getter // 클래스 내의 모든 필드의 getter 메서드 자동 생성
@NoArgsConstructor // 기본 생성자 자동추가 public Posts() {} 같은 효과
@Entity // 테이블과 링크될 클래스 ex) SalesManager.java -> sales_manager table
/*
실제 DB의 테이블과 매칭될 클래스이며 보통 Entity 클래스라고 부른다.
jpa를
 */
public class Posts {

    @Id // 해당 테이블의 PK 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK의 생성 규칙
    //GenerationTyhpe.IDENTITY = auto_increment
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // 빌더 패턴 클래스 생성 생성자 상단 선언시 이 필드만 빌더에 포함
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}

//setter 메소드를 만들지 않는 이유?
//해당 클래스의 인스턴스 값이 언제 어디서 변해야 하는지 코드상으로 구분 불가능해짐
// 차후 기능 변경시 복잡.. -> 해당 필드의 값이 꼭 변경이 필요한 경우에만 메소드 추가
// 목적과 의도를 나타나게
//setter 대신에 db에 값 삽입하는 방법  생성자를 통해 db값 삽입 후
// 값 변경이 필요한 경우에는 해당 이벤트에 맞는 public 메소드 호출하여 변경
// 생성자 대신 빌더 클래스를 통해 값 삽입 가능
// 빌더를 쓰는 이유는?> 어느 필드에 어떤 값을 채워야 할지 명확하게 인지
