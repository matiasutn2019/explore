package com.disney.explore.controller;

import com.disney.explore.domain.AppUser;
import com.disney.explore.domain.Role;
import com.disney.explore.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<AppUser> registrarUser(@RequestBody AppUser user) {
        //userService.addRoleToUser(user.getUsername(), "ROLE_USER");
        userService.registerUser(user);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/addroletouser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form) {
        userService.addRoleToUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/saverole")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/auth/saverole").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }
}
@Data
class RoleToUserForm {
    private String username;
    private String roleName;
}