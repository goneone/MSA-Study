//package com.rest.oauth2.web;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.security.Principal;
//
////@Controller
////Controller와 RestController의 차이점을 알 수 있을 겁니다.
////Controller는 단순의 페이지를 이동시키는 방법으로 보통 Model을 설정하여 해당 페이지에 보내게 되고
////VIew에서는 보통 JSP 페이지와 함께 쓰거나 JSTL과 함께 이용하여 쓰이게 됩니다.
////RestController는 return 되는 값을 페이지에 보여줍니다. POST 방식이나 PUT 방식을 쓰게 된다면 일반적인 브라우저에서는 볼 수 없습니다
////RESTful 접속 도구를 설치하여 볼 수 있습니다.
//
//
//@RestController //이건 string 값리턴이다..
//public class SampleController {
//
//   /* @GetMapping("/")
//    public String index(Model model, Principal principal) {
//        if (principal == null) {
//            model.addAttribute("message", "Hello Spring Security");
//        } else {
//            model.addAttribute("message", "Hello Spring Security"  + principal.getName());
//        }
//
//        return "index";
//    }*/
//
//    @GetMapping("/info")
//    public String info(Model model) {
//        model.addAttribute("message", "Hello index");
//        return "info";
//    }
//
//    @GetMapping("/dashboard")
//    public String dashboard(Model model, Principal principal) {
//        model.addAttribute("message", "Hello Spring Security" + principal.getName());
//        return "dashboard";
//    }
//
//   /* @GetMapping("/admin")
//    public String admin(Model model, Principal principal) {
//        model.addAttribute("message", "admin" + principal.getName());
//        return "admin";
//    }*/
//
//   @GetMapping("/admin")
//   public String admin() {
//       return "admin";
//   }
//
//   @GetMapping("/")
//   public String index() {
//       return "/";
//   }
//    //post요청은 usernameauthenticationfilter를 사용하고
//    //여기선 get요청만 처리함.
//    //@PostMapping("/login")
//    //@RequestMapping(value="/login" , method = {RequestMethod.GET, RequestMethod.POST})
//    @GetMapping("/login")
//    public String loginForm() {
//        return "login";
//    }
//    //Principal => 로그인한 사용자만 접근가능한 핸들러
//}
