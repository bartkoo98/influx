package com.example.influx.user;


import lombok.RequiredArgsConstructor;
import org.h2.engine.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Optional<UserAccount> getUserById(@PathVariable Long id) {
        return userRepository.findById(id);
    }

    public List<UserAccount> getUsers() {
        return userRepository.findAll();
    }
}
