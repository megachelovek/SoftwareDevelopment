package com.ssau.demo.Security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ssau.demo.Entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserPrincipal implements UserDetails {
  private Integer id;

  private String username;
  @JsonIgnore
  private String password;

  private Collection<? extends GrantedAuthority> authorities;

  public UserPrincipal(Integer id, String username, String password, Collection<? extends GrantedAuthority> authorities) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.authorities = authorities;
  }

  public static UserPrincipal create(UserEntity user) {
    List <UserEntity> tempList= new ArrayList<UserEntity>();
    tempList.add(new UserEntity("admin","$2a$04$FhKiTigK/p/8Slq.0cX8Vew3jAfsY4LrY0PLOFIoe1Hwqn8fGOniq"));

    List<GrantedAuthority> authorities =
            tempList.stream()
            .map(role -> new SimpleGrantedAuthority("ROLE_ADMIN"))
            .collect(Collectors.toList());

    return new UserPrincipal(
            user.getId(),
            user.getUsername(),
            user.getPassword(),
            authorities
    );
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Override
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  @Override
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
    this.authorities = authorities;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}