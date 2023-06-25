package com.example.web12.Servicer;

import java.util.List;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Component
@Service
public interface UserServicer {
  public List<User> user(); // hien thi tat ca nguoi dung
  public User createUser(User user2); // post user
  public User updateUser(User user1); // update thong tin user
  public User deleteUser(String usernames); // xoa user theo id
  public List<User> theId(String username2); // tim kiem theo ten

}
