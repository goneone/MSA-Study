package com.rest.oauth2.web;


        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.RequestParam;
        import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/registerTest")
    public String registerTest() {
        return "registerTest";
    }
}