package com.ssau.demo.Services;

import com.ssau.demo.Entity.UserEntity;
import com.ssau.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  private UserRepository userRepository;

  @Autowired
  public UserDetailsServiceImpl(UserRepository userRepository){
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
    UserEntity client = userRepository.findById(id);

    if(client == null){
      throw new UsernameNotFoundException(id + " not found");
    }

    Set<GrantedAuthority> setAuthority = new HashSet<>();
    setAuthority.add(new SimpleGrantedAuthority("ROLE_USER"));

    List<GrantedAuthority> authorities = new ArrayList<>(setAuthority);

    return new User(client.getUsername(), client.getPassword(), authorities);
  }
}