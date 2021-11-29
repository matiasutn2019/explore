package com.disney.explore.service;

import com.disney.explore.domain.request.UserRegisterRequest;
import com.disney.explore.domain.response.UserAuthenticatedResponse;
import org.springframework.security.core.userdetails.UserDetails;

public interface IUserService {

    public UserAuthenticatedResponse create(UserRegisterRequest userRequest) throws Exception;

        UserDetails loadUserByUsername(String email);
}
