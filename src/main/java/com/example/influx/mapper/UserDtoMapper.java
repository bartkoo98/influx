package com.example.influx.mapper;

import com.example.influx.entity.UserAccount;
import com.example.influx.entity.UserRole;
import com.example.influx.dto.UserAccountCredentialsDto;

import java.util.Set;
import java.util.stream.Collectors;

public class UserDtoMapper {
    public static UserAccountCredentialsDto map(UserAccount userAccount) {
        String email = userAccount.getEmail();
        String password = userAccount.getPassword();
        Set<String> roles = userAccount.getRoles()
                .stream()
                .map(UserRole::getName)
                .collect(Collectors.toSet());
        return new UserAccountCredentialsDto(email, password, roles);
    }




}
