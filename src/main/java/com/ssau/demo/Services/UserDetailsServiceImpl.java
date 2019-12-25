package com.ssau.demo.Services;

import com.ssau.demo.Entity.UserEntity;
import com.ssau.demo.Repository.UserRepository;
import com.ssau.demo.Security.UserPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  private final UserRepository userRepository;

  public UserDetailsServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String usernameOrEmail)
          throws UsernameNotFoundException {
    UserEntity user = userRepository.findByUsername(usernameOrEmail)
            .orElseThrow(() ->
                    new UsernameNotFoundException("User not found with username: " + usernameOrEmail)
            );

    return UserPrincipal.create(user);
  }

  @Transactional
  public UserDetails loadUserById(Integer id) {
    UserEntity user = userRepository.findById(id).orElse(new UserEntity("test","admin"));
//    UserEntity user = userRepository.findById(id).orElseThrow(
//            () -> new RuntimeException("User with id " + id + " is not found!")
//    );

    return UserPrincipal.create(user);
  }
}