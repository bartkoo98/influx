package com.example.influx.service;


import com.example.influx.entity.UserAccount;
import com.example.influx.dto.UserAccountCredentialsDto;
import com.example.influx.mapper.UserDtoMapper;
import com.example.influx.repository.UserRepository;
import com.example.influx.repository.UserRoleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private static final String DEFAULT_USER_ROLE = "USER";
    private static final String ADMIN_AUTHORITY = "ROLE_ADMIN";
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
//    private final PasswordEncoder passwordEncoder;



    public Optional<UserAccount> getUserById(@PathVariable Long id) {
        return userRepository.findById(id);
    }

    public List<String> findAllUserEmails() {
        return userRepository.findAllUsersByRoles_Name(DEFAULT_USER_ROLE)
                .stream()
                .map(UserAccount::getEmail)
                .toList();
    }

    public Optional<UserAccountCredentialsDto> findCredentialsByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(UserDtoMapper::map);
    }
    @Transactional
    public void deleteUserById(Long id) {
        if(isCurrentUserAdmin()) {
            userRepository.deleteById(id);
        }
    }

    private boolean isCurrentUserAdmin() {
        return SecurityContextHolder.getContext()
                .getAuthentication()
                .getAuthorities().stream()
                .anyMatch(authority -> authority.getAuthority().equals(ADMIN_AUTHORITY));
    }

//    @Transactional
//    public UserAccount register(UserRegistrationDto userRegistrationDto) {
//        UserAccount userAccount = new UserAccount();
//        UserRole defaultRole = userRoleRepository.findByName(DEFAULT_USER_ROLE);
//        userAccount.setRoles(Set.of(defaultRole));
//        userAccount.setEmail(userRegistrationDto.getEmail());
//        userAccount.setPassword(passwordEncoder.encode(userRegistrationDto.getPassword()));
//        userRepository.save(userAccount);
//        return userAccount;
//    }


}
