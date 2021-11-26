package com.disney.explore.controller;

import com.disney.explore.domain.request.UserRequest;
import com.disney.explore.domain.response.UserResponse;
import com.disney.explore.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> create(@RequestBody UserRequest userRequest) throws IOException {
        return new ResponseEntity<>(userService.create(userRequest), HttpStatus.CREATED);
    }

}