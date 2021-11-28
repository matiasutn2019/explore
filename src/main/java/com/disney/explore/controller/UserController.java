package com.disney.explore.controller;

import com.disney.explore.domain.request.UserRegisterRequest;
import com.disney.explore.domain.response.UserResponse;
import com.disney.explore.service.IUserService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping(
        value = "/auth/register",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponse> create(@RequestBody UserRegisterRequest userRegisterRequest)
        throws IOException {
        return new ResponseEntity<>(userService.create(userRegisterRequest), HttpStatus.CREATED);
    }

}