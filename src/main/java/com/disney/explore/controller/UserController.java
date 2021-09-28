package com.disney.explore.controller;

import com.disney.explore.domain.AppUser;
import com.disney.explore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<AppUser> registrarUser(@RequestBody AppUser user) throws Exception {
        userService.addRoleToUser(user.getUsername(), "ROLE_USER");
        userService.registerUser(user);
        return ResponseEntity.ok().build();
    }
}
