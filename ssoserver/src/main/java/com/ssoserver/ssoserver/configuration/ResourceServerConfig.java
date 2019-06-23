package com.ssoserver.ssoserver.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableResourceServer
@Configuration
public class ResourceServerConfig extends WebSecurityConfigurerAdapter {

  private static final String USER = "ZHI";
  private static final String PWD = "*ZHI";
  private static final String ROLE = "USER";

  @Autowired
  private AuthenticationManager authenticationManager;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // @formatter:off
    http.requestMatchers()
      .antMatchers("/login", "/oauth/authorize")
      .and()
      .authorizeRequests()
      .anyRequest()
      .authenticated()
      .and()
      .formLogin()
      .permitAll();
    // @formatter:on
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    // @formatter:off
    auth.parentAuthenticationManager(authenticationManager)
      .inMemoryAuthentication()
      .withUser(USER)
      .password(PWD)
      .roles(ROLE);
    // @formatter:on  
  }

}
