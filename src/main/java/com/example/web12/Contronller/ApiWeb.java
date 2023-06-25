package com.example.web12.Contronller;

import com.example.web12.Servicer.UserServicer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class ApiWeb {
  @Autowired
  private UserServicer userServicer;
  @GetMapping("/ad")
  public ResponseEntity<?> user(){
    List<User> user =userServicer.user();
    return ResponseEntity.ok(user);
  }
  @PostMapping("/ad")
  public ResponseEntity<?> createUser(@RequestBody User user2){
    User user =userServicer.createUser(user2);
    return ResponseEntity.ok(user);
  }
  @PutMapping("/ad")
  public ResponseEntity<?> updateUser(@RequestBody User user1){
    User user =userServicer.updateUser(user1);
    return ResponseEntity.ok(user);
  }
  @DeleteMapping("/ad")
  public ResponseEntity<?> deleteUser(@RequestParam String usernames){
    User user =userServicer.deleteUser(usernames);
    return ResponseEntity.ok(user);
  }
  @GetMapping("/ad/{username}")
  public ResponseEntity<?> theId( @RequestParam String username2){
    List<User> user =userServicer.theId(username2);
    return ResponseEntity.ok(user);
  }
}
