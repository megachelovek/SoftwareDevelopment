package com.ssau.demo.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;

@CrossOrigin
@RestController
public class LoginRestController {
  private static String encode(String password) {
    return new BCryptPasswordEncoder().encode(password);
  }


  @GetMapping(value = "/login", params = {"username", "password"})
  public ResponseEntity<?> getLogin(@RequestParam(value = "username", required = true) String username,@RequestParam(value = "password", required = true) String password) {
    //UserEntity user = userRepository.findById(username);
    if (username == null || password==null ) {
      return new ResponseEntity("user not found",HttpStatus.UNAUTHORIZED);
    }
    return new ResponseEntity("login OK", HttpStatus.OK);

  }

  @GetMapping(value = "/logout", params = {"logout"})
  public ResponseEntity<?> getLogout(@RequestParam(value = "logout", required = false) Boolean logout) {
    return new ResponseEntity((logout != null && logout) ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
  }

  @PostMapping("/registration")
  public ResponseEntity<?> postRegistration(@RequestBody LinkedHashMap entity) {
    String username = entity.get("username").toString();
    String password = encode(entity.get("password").toString());

    try {
    } catch (Exception e) {
      return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    return new ResponseEntity(null, HttpStatus.OK);
  }

  @PostMapping("/reset")
  public ResponseEntity<?> reset(@RequestBody LinkedHashMap entity) {
    String email = entity.get("email").toString();
    String password = encode(entity.get("password").toString());

    try {
      //ClientDAO.updatePassword(email, password);
    } catch (Exception e) {
      return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    return new ResponseEntity(null, HttpStatus.OK);
  }
}