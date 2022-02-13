package com.dongjae.book.springboot.web.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

/*
@Getter : 선언된 모든 필드 get메소드 생성
 */
@Getter
/*
@RequiredArgsConstructor : 선언된 모든 final 필드가 포험된 생성자 생성 , final이 없다면 생성자 포함 x
 */
@RequiredArgsConstructor
public class HelloResponseDto {
    private final String name;
    private final int amount;
}
