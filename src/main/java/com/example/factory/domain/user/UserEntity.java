package com.example.factory.domain.user;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;


@Getter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserEntity implements UserDetails {

    String username;
    String password;
    List<UserRole> authorities;
    boolean accountNonExpired;
    boolean accountNonLocked;
    boolean credentialsNonExpired;
    boolean enabled;

    public static UserEntity create(Context context) {
        UserEntity user = new UserEntity();
        user.username = context.login;
        user.password = context.password;
        user.authorities = context.roles;
        user.accountNonExpired = true;
        user.accountNonLocked = true;
        user.credentialsNonExpired = true;
        user.enabled = true;
        return user;
    }

    public record Context(String login,
                          String password,
                          List<UserRole> roles) {

    }
}
