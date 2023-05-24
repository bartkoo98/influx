package com.example.influx.controller;

import com.example.influx.entity.UserAccount;
import com.example.influx.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
//    private UserRepository userRepository;
//    private UserRoleRepository userRoleRepository;
//    private AuthenticationManager authenticationManager;
//    private PasswordEncoder passwordEncoder;



//    @PostMapping("/auth/register")
//    public ResponseEntity<String> registerNewUser(@RequestBody UserRegistrationDto userRegistrationDto) {
//        if(userRepository.existsByEmail(userRegistrationDto.getEmail())) {
//            return new ResponseEntity<>("Email is already exists!", HttpStatus.BAD_REQUEST);
//        }
//        UserAccount savedUser = userService.register(userRegistrationDto);
//        return new ResponseEntity<String>("User registered success!", HttpStatus.CREATED);
//    }

//    @PostMapping("/auth/login")
//    public ResponseEntity<String> login(@RequestBody UserLoginDto userLoginDto) {
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(userLoginDto.getEmail(),
//                        userLoginDto.getPassword()));
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        return new ResponseEntity<>("User signed in success!", HttpStatus.OK);
//    }

    @GetMapping("/users")
    public List<String> getUsers() {
        return userService.findAllUserEmails();
    }

    @GetMapping("/users/{id}")
    public Optional<UserAccount> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }



}
