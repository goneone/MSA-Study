package com.rest.oauth2.domain;

import com.rest.oauth2.domain.posts.Posts;
import com.rest.oauth2.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup() {
        //테스트 메소드 끝나고 repository 전체 비우는 코드. 이후 테스트코드에 영향 끼치지 않기 위해.
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글_잘_insert됩니까() {
        //given
        postsRepository.save(Posts.builder()
            .title("test 게시글")
            .author("테스트 저자")
            .content("테스트 내용")
            .build()
        );
        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts postTestMan = postsList.get(0);
        assertThat(postTestMan.getAuthor(), is("테스트 저자"));
        assertThat(postTestMan.getContent(), is("테스트 내용"));


    }
}
