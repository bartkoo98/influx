package com.example.influx.user;


import com.example.influx.user.dto.UserAccountCredentialsDto;
import com.example.influx.user.dto.UserRegistrationDto;
import com.example.influx.user.mapper.UserAccountCredentialsDtoMapper;
import com.example.influx.user.repository.UserRepository;
import com.example.influx.user.repository.UserRoleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {
    private static final String DEFAULT_USER_ROLE = "USER";
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;



    public Optional<UserAccount> getUserById(@PathVariable Long id) {
        return userRepository.findById(id);
    }

    public List<UserAccount> getUsers() {
        return userRepository.findAll();
    }

    public Optional<UserAccountCredentialsDto> findCredentialsByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(UserAccountCredentialsDtoMapper::map);
    }

    @Transactional
    public UserAccount register(UserRegistrationDto userRegistrationDto) {
        UserAccount userAccount = new UserAccount();
        UserRole defaultRole = userRoleRepository.findByName(DEFAULT_USER_ROLE);
        userAccount.setRoles(Set.of(defaultRole));
        userAccount.setEmail(userRegistrationDto.getEmail());
        userAccount.setPassword(passwordEncoder.encode(userRegistrationDto.getPassword()));
        userRepository.save(userAccount);
        return userAccount;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


}
