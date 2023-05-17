package com.example.influx.user;

import com.example.influx.user.dto.UserRegistrationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/register")
    public String register(UserRegistrationDto userRegistrationDto) {
        userService.register(userRegistrationDto);
        return "redirect:/";
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
