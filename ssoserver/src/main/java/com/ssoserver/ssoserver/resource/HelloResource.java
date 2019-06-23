package com.ssoserver.ssoserver.resource;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/hello")
public class HelloResource {

  @GetMapping
  public String hello() {
    return "Hello World";
  }

  @GetMapping("/principal")
  public Principal getPricipal(Principal principal) {
    return principal;
  }

}
