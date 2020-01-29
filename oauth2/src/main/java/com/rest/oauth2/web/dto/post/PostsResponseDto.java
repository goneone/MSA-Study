package com.rest.oauth2.web.dto.post;

import com.rest.oauth2.domain.posts.Posts;
import lombok.Getter;


//PostsListResponseDto와 차이점은
//PostsResponseDto 얘는 글 내용이랑 다 가져오는 얘임.
//긍까 게시글 클릭했을 때.
@Getter
public class PostsResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
