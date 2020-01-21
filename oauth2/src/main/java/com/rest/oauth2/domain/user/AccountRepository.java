package com.rest.oauth2.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    //jpa == 인터페이스만 만들어도 인터페이스의 구현체가 자동으로 만들어지고 빈에 등록됨.
    Account findByUsername(String username);
    Account findByEmail(String email);

    //Optional<Account> findByEmail(String email);

}
