package com.rest.oauth2.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
//Ajax 등을 통해 다른 도메인의 서버에 url(data)를 호출할 경우 XMLHttpRequest는 보안상의 이유로 자신과 동일한 도메인으로만 HTTP요청을 보내도록 제한하고 있어 에러가 발생한다.
//내가 만든 웹서비스에서 사용하기 위한 rest api 서버를 무분별하게 다른 도메인에서 접근하여 사용하게 한다면 보안상 문제가 될 수 있기 때문에 제한하였지만
//지속적으로 웹 애플리케이션을 개선하고 쉽게 개발하기 위해서는 이러한 request가 꼭 필요하였기에 그래서 XMLHttpRequest가 cross-domain을 요청할 수 있도록하는 방법이 고안되었다.
//그것이 CORS 이다.
//CORS란? CORS(Cross-origin resource sharing)이란, 웹 페이지의 제한된 자원을 외부 도메인에서 접근을 허용해주는 메커니즘이다.
//스프링에서 CORS 설정하기.
//스프링 RESTful Service에서 CORS를 설정은 @CrossOrigin 어노테이션을 사용하여 간단히 해결 할 수 있다.
// RestController를 사용한 클래스 자체에 적용할 수 도 있고, 특정 REST API method에도 설정 가능하다.
//또한, 특정 도메인만 접속을 허용할 수도 있다.

//HTTP Request 요청에 앞서 Preflight Request 라는 요청이 발생되는데, 이는 해당 서버에 요청하는 메서드가 실행 가능한지(권한이 있는지) 확인을 위한 요청이다
//maxAge는 Preflight request를 캐시할 시간이다 단위는 초단위이며, 3,600초는 1시간이다
// Preflight Request를 웹브라우저에 캐시한다면 1시간동안은 서버에 재 요청하지 않는다는 의미

@RestController
@RequestMapping("/api/test")
public class TestController {
    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public String userAccess() {
        return "User Content.";
    }

    @GetMapping("/mod")
    @PreAuthorize("hasRole('MODERATOR')")
    public String moderatorAccess() {
        return "Moderator Board.";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }


}
