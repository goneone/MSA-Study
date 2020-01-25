//package com.rest.oauth2.web;
//
//import com.rest.oauth2.domain.user.User;
//import com.rest.oauth2.domain.user.Role;
//import com.rest.oauth2.service.AccountService;
//import lombok.AllArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//
//
////@RequiredArgsConstructor 초기화 되지 않은 final 필드와 @NonNull 어노테이션이 붙은 필드에 대한 생성자 생성
////
////@AllArgsConstructor 모든 필드에 대한 생성자 생성.
////@RequestMapping("/register")  //@RequestMapping("/users")
////@RequestMapping("/register") 로 주면
////화면에서 localhost:8080/register/abc 로 호출하면
////해당컨트롤러를타고 해당컨트롤러의 abc 메소드 탐
////해당 메소드에도 @RequestMapping("/abc")
////public String abc(Model model) { 이런식으로 되어있을시..~~!!
//@AllArgsConstructor
//@RestController
//public class AccountController {
//
//    @Autowired
//    private AccountService accountService;
//
//    @GetMapping("/user")
//    public List<User> listUser() {
//        return accountService.findAll();
//    }
//
////    @PostMapping("/register")
////    public User register(@RequestBody User user) {
////        user.setRole(Role.USER);
////        return accountService.save(user);
////    }
//
//   /* @GetMapping("/admin")
//    public String admin(Model model) {
//        return "admin";
//    }
//*/
//    /*@GetMapping("/login")
//    public String login() {
//        return "login";
//    }*/
//}
