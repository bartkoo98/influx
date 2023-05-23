package com.example.influx.user;

import com.example.influx.user.dto.UserLoginDto;
import com.example.influx.user.dto.UserRegistrationDto;
import com.example.influx.user.repository.UserRepository;
import com.example.influx.user.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;
    private UserRepository userRepository;
    private UserRoleRepository userRoleRepository;
    private AuthenticationManager authenticationManager;
    private PasswordEncoder passwordEncoder;

    public UserController(UserService userService, UserRepository userRepository, UserRoleRepository userRoleRepository, AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/auth/register")
    public ResponseEntity<String> registerNewUser(@RequestBody UserRegistrationDto userRegistrationDto) {
        if(userRepository.existsByEmail(userRegistrationDto.getEmail())) {
            return new ResponseEntity<>("Email is already exists!", HttpStatus.BAD_REQUEST);
        }
        UserAccount savedUser = userService.register(userRegistrationDto);
        return new ResponseEntity<String>("User registered success!", HttpStatus.CREATED);
    }

    @PostMapping("/auth/login")
    public ResponseEntity<String> login(@RequestBody UserLoginDto userLoginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userLoginDto.getEmail(),
                        userLoginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("User signed in success!", HttpStatus.OK);
    }

    @GetMapping("/users")
    public List<UserAccount> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/users/{id}")
    public Optional<UserAccount> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }


    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

}
