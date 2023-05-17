package com.example.influx.user.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
public class UserAccountCredentialsDto {
    private final String email;
    private final String password;
    private final Set<String> roles;
}
