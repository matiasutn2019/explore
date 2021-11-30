package com.disney.explore.controller;

import com.disney.explore.domain.request.UserLoginRequest;
import com.disney.explore.domain.request.UserRegisterRequest;
import com.disney.explore.domain.response.UserAuthenticatedResponse;
import com.disney.explore.domain.response.UserCreatedResponse;
import com.disney.explore.exception.UserAlreadyRegisteredException;
import com.disney.explore.service.IUserService;
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
    public ResponseEntity<UserCreatedResponse> create(@RequestBody UserRegisterRequest userRegisterRequest)
        throws UserAlreadyRegisteredException {
        return new ResponseEntity<>(userService.create(userRegisterRequest), HttpStatus.CREATED);
    }

    @PostMapping(
        value = "/auth/login",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserAuthenticatedResponse> login(@RequestBody UserLoginRequest userLoginRequest)
        throws Exception {

        return new ResponseEntity<>(userService.login(userLoginRequest), HttpStatus.OK);
    }

}