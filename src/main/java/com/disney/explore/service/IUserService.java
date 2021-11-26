package com.disney.explore.service;

import com.disney.explore.domain.request.UserRequest;
import com.disney.explore.domain.response.UserResponse;

public interface IUserService {

  public UserResponse create(UserRequest userRequest);

}
