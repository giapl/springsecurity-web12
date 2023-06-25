package com.example.web12.Enity;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="user")
public class user {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private long id;
  @Column(name = "username")
  private String username;
  @Column(name = "password")
  private String password;
  @Column(name = "email")
  private String email;
  @Column(name = "authentio")
  private String authentic;

  public user(String username,String password, String email,String authentic){
    this.username=username;
    this.password=password;
    this.email=email;
    this.authentic =authentic;
  }
  public String getUsername(){
    return this.username=username;
  }
  public void setUsername(String username1){
    this.username=username1;
  }
  public String getPassword(){
    return this.password=password;
  }
  public void setPassword(String password1){
    this.password=password;
  }
  public String getEmail(){
    return this.email=email;
  }
  public void setEmail(String email1){
    this.email=email1;
  }
  public String getAuthentic(){
    return this.authentic = authentic;
  }

  public void setAuthentic(String authentio) {
    this.authentic = authentio;
  }

  @Override
  public String toString() {
    String name = this.username + this.password;
    return name;
  }
}
