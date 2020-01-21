package com.rest.oauth2.service;

import com.rest.oauth2.domain.user.Account;
import com.rest.oauth2.domain.user.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

//account와 관련된 비즈니스로직을 처리하거나 데이터베이스를 사용할 때 앞뒤로 해줘야 할 일들 등을 하는 구현체
@Service
public class AccountService implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    public Account save (Account account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        return accountRepository.save(account);
    }

    public Account register (Account account) {
        return accountRepository.save(account);
    }
    /*@PostConstruct
    public void init(){
        User autumn = userRepository.findByUsername("autumn");
        if(autumn == null){
            User user = new User();
            user.setUsername("autumn");
            user.setPassword("pass");
            user.setRole(Role.USER);
            System.out.println("******    " + this.save(user));

        }
    }*/

    // UserDetailsService 인터페이스는 spring security에서 오는 거고.
    //스프링 시큐리티에서 authentication을 관리할 때
    //dao를 사용해서 저장소에 들어있는 유저정보를 가지고 인증을 할 때 쓰는 인터페이스

    //loadUserByUsername의 역할
    //data를 가져와서 userdatails 타입으로 바꿔주는게 이 메소드의 역할
    @Override public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    //Account account = accountRepository.findByUsername(username);
    Account account = accountRepository.findByEmail(username);
    if(account == null) {
        throw new UsernameNotFoundException(username);
    }

    List<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
    //account를 userdetails로 바꾸기 편하도록 스프링 시큐리티가 제공함.

        /*return User.builder()
        .username(account.getUsername())
        .password(account.getPassword())
        //.roles(account.getRole())
        .build();*/
    return new User(account.getUsername(), account.getPassword(), authorities);
}

}

