package com.dongjae.book.springboot.web;

import com.dongjae.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
@RestController
컨트롤러를 JSON으로 반환하는 컨트롤러로 만듬
 */
@RestController
public class HelloController {

    /*
    Get 요청을 받을 수 있는 API
     */
    @GetMapping("/hello")
    public String first() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    /*
    requestparam 외부에서 넘긴 파라미터를 가져오는 어노테이션
    자동으로 name(string name) 에 저장됨
     */
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
}
