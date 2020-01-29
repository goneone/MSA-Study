package com.rest.oauth2.web;

import com.rest.oauth2.service.PostsService;
import com.rest.oauth2.web.dto.post.PostsListResponseDto;
import com.rest.oauth2.web.dto.post.PostsResponseDto;
import com.rest.oauth2.web.dto.post.PostsSaveRequestDto;
import com.rest.oauth2.web.dto.post.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RequiredArgsConstructor 초기화 되지 않은 final 필드와 @NonNull 어노테이션이 붙은 필드에 대한 생성자 생성
//
//@AllArgsConstructor 모든 필드에 대한 생성자 생성.

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/posts")
public class PostsApiController {

    private final PostsService postsService;

    //post 전체 가져오기
    @GetMapping("/list")
    public List<PostsListResponseDto> allAccess() {
        return postsService.findAllDesc();
    }

    //post 하나 가져오기
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public PostsResponseDto findById(@PathVariable Long id) { //@PathVariable어노테이션은? 말 그대로 URL 경로에 변수 넣어주는거
        return postsService.findById(id);
    }

    //post 쓰기
    @PostMapping("/")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    //post 수정
    @PutMapping("/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    //post 삭제
    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }

    //post 삭제
    /*
    @GetMapping("/getPostList") //게시물 가져오기
    public List<PostsListResponseDto> getPostList() {
        return postsService.findAllDesc();
    }

    @PostMapping("/registerTest") //게시물 등록
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }*/
}
