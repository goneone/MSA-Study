package com.rest.oauth2.domain;

import com.rest.oauth2.domain.user.User;
import com.rest.oauth2.domain.user.UserRepository;
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
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @After
    public void cleanup() {
        //테스트 메소드 끝나고 repository 전체 비우는 코드. 이후 테스트코드에 영향 끼치지 않기 위해.
        userRepository.deleteAll();
    }

    @Test
    public void 회원가입_잘_됩니까() {
        //given
        userRepository.save(User.builder()
            .username("테스트맨")
            .email("testing@naver.com")
            .password("test180")
            .build()
        );
        //when
        List<User> userList = userRepository.findAll();

        //then
        User user1 = userList.get(0);
        assertThat(user1.getUsername(), is("테스트맨"));
        assertThat(user1.getEmail(), is("testing@naver.com"));
    }
}
