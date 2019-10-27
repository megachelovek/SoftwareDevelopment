package com.ssau.demo;

import com.ssau.demo.Services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class MainConfiguration extends WebSecurityConfigurerAdapter {

  @Autowired
  public MainConfiguration(UserDetailsServiceImpl userDetailsService){
    this.userDetailsService = userDetailsService;
  }

  private UserDetailsServiceImpl userDetailsService;

  @Bean
  public CorsConfigurationSource corsConfigurationSource() {
    try {
      UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
      source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
      return source;
    }catch (Exception ex){

    }
    return null;
  }

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.cors()
            .and().httpBasic()
            .and().csrf().disable().
            authorizeRequests().antMatchers("/", "/login", "/logout", "/registration", "/reset").permitAll();

    http.authorizeRequests().antMatchers("/profiles", "/trainers", "/clients", "/client_sessions", "/sessions", "lobbies").authenticated();

    http.formLogin()
            .loginPage("/login")
            .failureUrl("/login?error=true")
            .usernameParameter("username")
            .passwordParameter("password");
    http.logout().permitAll().logoutUrl("/logout").invalidateHttpSession(true);
  }
}