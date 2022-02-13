package com.dongjae.book.springboot.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
/*
Dto 클래스의 Lombok 라이브러리가 잘 작동되는지 확인하는 테스트
 */
public class HelloResponseDtoTest {

    @Test
    public void HelloDtoTest() {
        //given
        String name = "test";
        int amount = 10000;
        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);
        //then
        /*
        assertj의 테스트 검증 라이브러리 메서드
         */

        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
