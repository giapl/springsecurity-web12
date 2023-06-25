package com.example.web12.WebSercurity;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebConfig {
  @Configuration
  public class SecurityConfiguration {
    // tao tk vs mk trong bo nho memory
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
      InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
      UserDetails user = User.withDefaultPasswordEncoder()
          .username("user")
          .password("123") // ma hoa mk
          .roles("USER")
          .build();
      UserDetails admin = User.withDefaultPasswordEncoder()
          .username("admin")
          .password("admin") // ma hoa mk
          .roles("ADMIN")
          .build();
      manager.createUser(user);
      manager.createUser(admin);
      return manager;
    }
  }
  // phan quyen cho tk
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
        .requestMatchers(HttpMethod.GET,"/home").hasRole("USER")
        .requestMatchers(HttpMethod.POST,"/admin/ad").hasAnyRole("ADMIN")
        .requestMatchers(HttpMethod.GET,"/admin/ad").hasAnyRole("ADMIN")
        .requestMatchers(HttpMethod.DELETE,"/admin/ad").hasAnyRole("ADMIN")
        .requestMatchers(HttpMethod.PUT,"/admin/ad").hasAnyRole("ADMIN")
        .anyRequest().authenticated()
        .and()
        .httpBasic();
    return http.build();
  }
}
