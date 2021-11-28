package com.disney.explore.service;

import com.disney.explore.domain.request.UserRegisterRequest;
import com.disney.explore.domain.response.UserResponse;
import java.io.IOException;

public interface IUserService {

  public UserResponse create(UserRegisterRequest userRequest) throws IOException;

}
