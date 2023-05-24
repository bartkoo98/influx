package com.example.influx.security;

import com.example.influx.entity.UserRole;
import com.example.influx.service.UserService;
import com.example.influx.dto.UserAccountCredentialsDto;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserService userService;

    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userService.findCredentialsByEmail(username)
                .map(this::createUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException("User with email %s not found".formatted(username)));
    }

    private UserDetails createUserDetails(UserAccountCredentialsDto userAccountCredentialsDto) {
        return User.builder()
                .username(userAccountCredentialsDto.getEmail())
                .password(userAccountCredentialsDto.getPassword())
                .roles(userAccountCredentialsDto.getRoles().toArray(String[]::new))
                .build();
    }

    private Collection<GrantedAuthority> mapRolesToAuthorities(Set<UserRole> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());
    }
}
