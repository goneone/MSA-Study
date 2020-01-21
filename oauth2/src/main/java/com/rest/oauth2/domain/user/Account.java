package com.rest.oauth2.domain.user;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String email;

    public Account() {
    }

    @Enumerated(EnumType.STRING) //JPA로 데이터베이스 저장할 때 Enum값을 STRING으로 하도록. (기본적으로는 int로 된 숫자가 저장 되는데 그럴 경우 데이터베이스 확인할 때 그 값이 무슨 코드를 의미하는지 알 수 없음.
    @Column(nullable = false)
    private Role role;

    @Builder
    public Account(String username, String password, String email, Role role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}
