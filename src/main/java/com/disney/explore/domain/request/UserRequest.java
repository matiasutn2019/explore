package com.disney.explore.domain.request;

import com.disney.explore.domain.entity.Role;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
  private String email;
  private String password;
  private List<Role> roles;

}
