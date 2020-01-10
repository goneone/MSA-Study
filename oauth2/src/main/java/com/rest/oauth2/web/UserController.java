package com.rest.oauth2.web;

import com.rest.oauth2.domain.user.User;
import com.rest.oauth2.service.UserService;
import com.rest.oauth2.web.dto.UserRegisterRequestDto;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//@RequiredArgsConstructor 초기화 되지 않은 final 필드와 @NonNull 어노테이션이 붙은 필드에 대한 생성자 생성
//
//@AllArgsConstructor 모든 필드에 대한 생성자 생성.
//@RequestMapping("/register")  //@RequestMapping("/users")
//@RequestMapping("/register") 로 주면
//화면에서 localhost:8080/register/abc 로 호출하면
//해당컨트롤러를타고 해당컨트롤러의 abc 메소드 탐
//해당 메소드에도 @RequestMapping("/abc")
//public String abc(Model model) { 이런식으로 되어있을시..~~!!
@AllArgsConstructor
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public List<User> listUser() {
        return userService.findAll();
    }

    @PostMapping("/user")
    public User create(@RequestBody User user) {
        return userService.save(user);
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

}
