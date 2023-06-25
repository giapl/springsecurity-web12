package com.example.web12.Contronller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginContronller {
  @GetMapping("/home")
  public ResponseEntity<String> home(){
    return ResponseEntity.ok("this is the page");
  }
  @GetMapping("/admin")
  public ResponseEntity<String> admin(){
    return ResponseEntity.ok("this is a page admin");
  }
}
