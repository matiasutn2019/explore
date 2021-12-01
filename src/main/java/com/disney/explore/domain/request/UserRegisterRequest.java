package com.disney.explore.domain.request;

import com.disney.explore.common.validation.ValidationMessages;
import javax.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterRequest {
    @Email(message = ValidationMessages.REQUEST_PARAM_EMAIL_ERROR_MESSAGE)
    private String email;
    private String password;

}
