package com.ssau.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class MainConfiguration extends WebSecurityConfigurerAdapter {
  @Autowired
  private MyBasicAuthenticationEntryPoint authenticationEntryPoint;

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication()
            .withUser("admin").password(passwordEncoder().encode("admin"))
            .authorities("USER");
  }

  @Override
  protected void configure(final HttpSecurity http) throws Exception {
    http
            .authorizeRequests()
            .antMatchers("/").permitAll()
            .anyRequest().permitAll()//authenticated()
            .and()
            .formLogin()
            .loginPage("/login")
            .permitAll()
            .and()
            .logout()
            .permitAll();

//    http
//            .sessionManagement()
//            .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//            .csrf().disable()
//            .exceptionHandling().and()
//            .anonymous().and()
//            .servletApi().and()
//            .authorizeRequests()
//            .antMatchers(HttpMethod.GET, "/").permitAll()
//            .antMatchers(HttpMethod.POST, "/").permitAll()
//            .antMatchers(HttpMethod.DELETE, "/").permitAll()
//            .antMatchers(HttpMethod.PUT, "/").permitAll()
//            .anyRequest().authenticated();

   /* http.antMatcher("/**").authorizeRequests().anyRequest().permitAll()
            .antMatchers(HttpMethod.GET, "/**").permitAll()
            .antMatchers(HttpMethod.POST, "/**").permitAll()
            .antMatchers(HttpMethod.DELETE, "/**").permitAll()
            .antMatchers(HttpMethod.PUT, "/**").permitAll();*/

  }


  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}

