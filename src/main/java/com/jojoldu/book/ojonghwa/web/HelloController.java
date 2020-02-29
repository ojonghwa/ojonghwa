package com.jojoldu.book.ojonghwa.web;

import com.jojoldu.book.ojonghwa.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {      //p60

    @GetMapping("/hello")       // HTTP GET 요청처리 API 생성
    public String hello() {     // /hello로 요청이 오면 문자열 hello 반환
        return "hello";
    }

    @GetMapping("/hello/dto")   //p75
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                     @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
}
