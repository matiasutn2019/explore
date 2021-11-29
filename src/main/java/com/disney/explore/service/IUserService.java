package com.disney.explore.service;

import com.disney.explore.domain.request.UserLoginRequest;
import com.disney.explore.domain.request.UserRegisterRequest;
import com.disney.explore.domain.response.UserAuthenticatedResponse;
import com.disney.explore.domain.response.UserCreatedResponse;
import org.springframework.security.core.userdetails.UserDetails;

public interface IUserService {

    UserCreatedResponse create(UserRegisterRequest userRequest) throws Exception;

    UserDetails loadUserByUsername(String email);

    UserAuthenticatedResponse login(UserLoginRequest userLoginRequest) throws Exception;

}
