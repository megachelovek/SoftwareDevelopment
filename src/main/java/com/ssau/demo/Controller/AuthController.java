package com.ssau.demo.Controller;

import com.ssau.demo.DTO.ApiResponse;
import com.ssau.demo.DTO.AuthenticationResponse;
import com.ssau.demo.DTO.LoginDto;
import com.ssau.demo.DTO.SignUpDto;
import com.ssau.demo.Entity.UserEntity;
import com.ssau.demo.Entity.UserRoleEntity;
import com.ssau.demo.Repository.UserRepository;
import com.ssau.demo.Repository.UserRoleRepository;
import com.ssau.demo.Security.TokenProvider;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

  private final AuthenticationManager authenticationManager;

  private final UserRepository userRepository;

  private final UserRoleRepository roleRepository;

  private final PasswordEncoder passwordEncoder;

  private final TokenProvider tokenProvider;

  public AuthController(AuthenticationManager authenticationManager,
                        UserRepository userRepository,
                        UserRoleRepository roleRepository,
                        PasswordEncoder passwordEncoder,
                        TokenProvider tokenProvider) {
    this.authenticationManager = authenticationManager;
    this.userRepository = userRepository;
    this.roleRepository = roleRepository;
    this.passwordEncoder = passwordEncoder;
    this.tokenProvider = tokenProvider;
  }

  @RequestMapping(value = "/signin", method = RequestMethod.POST)
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginDto signinModel) {

    UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
            signinModel.getUsername(),
            signinModel.getPassword()
    );

    Authentication authentication = authenticationManager.authenticate(
            token
    );

    SecurityContextHolder.getContext().setAuthentication(authentication);

    String jwt = tokenProvider.generateToken(authentication);
    return ResponseEntity.ok(new AuthenticationResponse(jwt));
  }

  @RequestMapping(value = "/signup", method = RequestMethod.POST,produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<?> registerUser(@RequestBody SignUpDto signUpRequest) {
    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
      return new ResponseEntity(
              new ApiResponse(false, "Username is already taken!"),
              HttpStatus.BAD_REQUEST);
    }

    UserEntity user = new UserEntity(signUpRequest.getUsername(),signUpRequest.getPassword());

    user.setPassword(passwordEncoder.encode(user.getPassword()));

    UserRoleEntity userRole = roleRepository.findByName(UserRoleEntity.UserRoleType.USER)
            .orElseThrow(() -> new RuntimeException("User Role not set."));

    user.setRoles(Collections.singleton(userRole));

    UserEntity result = userRepository.save(user);

    URI location = ServletUriComponentsBuilder
            .fromCurrentContextPath().path("/users/{username}")
            .buildAndExpand(result.getUsername()).toUri();

    return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
  }
}
