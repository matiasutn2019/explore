package com.disney.explore.domain.request;

import com.disney.explore.common.validation.ValidationMessages;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginRequest {
    @Email(message = ValidationMessages.REQUEST_PARAM_EMAIL_ERROR_MESSAGE)
    private String email;
    @NotBlank(message = ValidationMessages.REQUEST_PARAM_EMPTY_ERROR_MESSAGE)
    private String password;

}
