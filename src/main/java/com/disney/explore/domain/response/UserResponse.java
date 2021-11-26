package com.disney.explore.domain.response;

import com.disney.explore.domain.entity.Role;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

  private Long id;
  private String email;
  private String password;
  private List<Role> roles;

}
