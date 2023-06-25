package com.example.web12.Servicer;

import java.util.ArrayList;
import java.util.List;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public class UserServicerImpl implements UserServicer{
 public static List<User> user=new ArrayList<User>();
  @Override
  public List<User> user() {
    return user;
  }

  @Override
  public User createUser(User user2) {
    this.user.add(user2);
    return user2;
  }

  @Override
  public User updateUser(User user1) {
    for(int i=0;i<=user.size();i++){
      if(user.get(i).getUsername()==user1.getUsername()){
        return user.set(i,user1);
      }
    }
    return null;
  }

  @Override
  public User deleteUser(String usernames) {
    for(int i=0;i<=user.size();i++){
      if(user.get(i).getUsername()==usernames){
        user.remove(usernames);
        break;
      }
    }
    return null;
  }

  @Override
  public List<User> theId(String username2) {
    if (user.contains(username2)) {
      return user;
    }
    return null;
  }
}
