package com.dongjae.book.springboot.web;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;

/*
@RunWith : 테스트 진행할때 Junit + springrunnerclass 같이 실행
spring boot - Junit 연결
 */
@RunWith(SpringRunner.class)
/*
@WebMvcTest : 컨트롤러만 사용할 경우 선언
 */
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    /*
    @Autowired : 스프링이 관리할 수 있게 Bean 객체로 등록
    */
    @Autowired
    private MockMvc mvc; // 웹 api 테스트용 MockMvc , 스프링 mvc 테스트의 시작점 get,post api 테스트

    @Test
    public void hello리턴() throws Exception {
        String hello = "hello";
        mvc.perform(get("/hello")) // Mockmvc를 통해 맵핑된 hello 주소 테스트 , 체이닝 지원(.andExpect)
                .andExpect(status().isOk()) //상태코드 200인지 아닌지 검증 , 400,500번대는 에러
                .andExpect(content().string(hello)); //mvc.perform의 결과 검증
    }

    @Test
    public void helloDto리턴() throws Exception {
        String name = "JSO";
        int amount = 50;

        // param : api 테스트 요청 파라미터 설정, only String 날짜,숫자는 모두 string으로 바꾸어야함
        mvc.perform(get("/hello/dto").param("name", name).param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
