package com.rest.oauth2.config;

import com.rest.oauth2.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder encoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Autowired
    private AccountService accountService;

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/resources/**")
                .antMatchers("/css/**")
                .antMatchers("/vendor/**")
                .antMatchers("/js/**")
                .antMatchers("/favicon*/**")
                .antMatchers("/img/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.
        authorizeRequests()
        .antMatchers("/", "/index", "/register", "/getPostList", "/user", "/registerTest", "/login").permitAll()
        //.anyRequest().authenticated() //어느 요청이든 인증이 필요하다 //뭔가 요청이 들어오면 스프링 시큐리티는
        .anyRequest().permitAll()
        //스프링 컨텍스트라는 저장소에서 authentication이라는 객체가 있는지 확인한다.
        //없으면. 그러면 로그인 페이지로 간다.
        .and()
     .formLogin()
        .loginPage("/login") //get 요청은 form을 보여주고 post요청은 usernamepasswordauthenticationfilter가 처리함.
        .defaultSuccessUrl("/admin", true)

        .permitAll()
        .and()
     .httpBasic()
        .and()
     .logout()
        .logoutSuccessUrl("/index")
        .permitAll();
    }
    //스프링 시큐리티의 모든 인증은 AuthenticationManager를 통해 이루어진다.
    //AuthenticationManager를 생성하기 위해서는 AuthenticationManagerBuilder를 사용한다.
    //로그인 처리, 즉 인증을 위해서는 UserDetailService를 통해서 필요한 정보들을 가져오는데
    //여기서는 accountService에서 처리한다.

    //이 메소드를 사용해서 우리가 원하는 유저정보를 설정 할 수 있다.
   /* @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(accountService).passwordEncoder(encoder());
    }*/
}

