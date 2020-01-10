package com.rest.oauth2.web;

import com.rest.oauth2.service.PostsService;
import com.rest.oauth2.web.dto.PostsListResponseDto;
import com.rest.oauth2.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RequiredArgsConstructor 초기화 되지 않은 final 필드와 @NonNull 어노테이션이 붙은 필드에 대한 생성자 생성
//
//@AllArgsConstructor 모든 필드에 대한 생성자 생성.
@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @GetMapping("/getPostList")
    public List<PostsListResponseDto> getPostList() {
        return postsService.findAllDesc();
    }

    @PostMapping("/registerTest")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }
}
