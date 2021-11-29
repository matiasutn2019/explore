package com.disney.explore.controller;

import com.disney.explore.domain.request.UserLoginRequest;
import com.disney.explore.domain.request.UserRegisterRequest;
import com.disney.explore.domain.response.UserAuthenticatedResponse;
import com.disney.explore.security.JwtService;
import com.disney.explore.service.IUserService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @PostMapping(
        value = "/auth/register",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserAuthenticatedResponse> create(@RequestBody UserRegisterRequest userRegisterRequest)
        throws Exception {
        return new ResponseEntity<>(userService.create(userRegisterRequest), HttpStatus.CREATED);
    }

    @PostMapping(
        value = "/auth/login",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public UserAuthenticatedResponse login(@RequestBody UserLoginRequest userLoginRequest)
        throws Exception {
        try {
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userLoginRequest.getEmail(), userLoginRequest.getPassword());
            authenticationManager.authenticate(authentication);
        } catch (BadCredentialsException e) {
            throw new Exception("Invalid username or password!!!", e);
        }
        UserDetails userDetails = userService.loadUserByUsername(userLoginRequest.getEmail());
        String token = jwtService.createToken(userDetails);
        return new UserAuthenticatedResponse(1L, userLoginRequest.getEmail(), token);
    }

}