package com.delivery.security.impl;

import com.delivery.DTO.login.LoginResponse;
import com.delivery.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailImpl implements UserDetails {
    private Long id;
    private String userName;
    private String email;
    @JsonIgnore
    private String password;
    private List<? extends GrantedAuthority> authorities;

    public static UserDetailImpl convertUserEntityToUserDetail(UserEntity user){
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name())).collect(Collectors.toList());
        return new UserDetailImpl(
                user.getId(),
                user.getUserName(),
                user.getEmail(),
                user.getPassword(),
                authorities
        );
    }

    public static LoginResponse convertAuthPrincipalToLoginResponse(UserDetailImpl userDetail){
        List<SimpleGrantedAuthority> roleList = userDetail.authorities
                .stream().map(auth -> new SimpleGrantedAuthority(auth.getAuthority()))
                .collect(Collectors.toList());
        return LoginResponse
                .builder()
                .id(userDetail.id)
                .userName(userDetail.userName)
                .email(userDetail.email)
                .roles(roleList)
                .build();
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
