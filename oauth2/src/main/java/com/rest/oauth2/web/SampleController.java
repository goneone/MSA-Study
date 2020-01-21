package com.rest.oauth2.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

//@Controller
@RestController
public class SampleController {

   /* @GetMapping("/")
    public String index(Model model, Principal principal) {
        if (principal == null) {
            model.addAttribute("message", "Hello Spring Security");
        } else {
            model.addAttribute("message", "Hello Spring Security"  + principal.getName());
        }

        return "index";
    }*/

    @GetMapping("/info")
    public String info(Model model) {
        model.addAttribute("message", "Hello index");
        return "info";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, Principal principal) {
        model.addAttribute("message", "Hello Spring Security" + principal.getName());
        return "dashboard";
    }

    @GetMapping("/admin")
    public String admin(Model model, Principal principal) {
        model.addAttribute("message", "admin" + principal.getName());
        return "admin";
    }

    //post요청은 usernameauthenticationfilter를 사용하고
    //여기선 get요청만 처리함.
    //@PostMapping("/login")
    //@RequestMapping(value="/login" , method = {RequestMethod.GET, RequestMethod.POST})
    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }
    //Principal => 로그인한 사용자만 접근가능한 핸들러
}
