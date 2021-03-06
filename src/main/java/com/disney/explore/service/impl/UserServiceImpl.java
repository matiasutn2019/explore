package com.disney.explore.service.impl;

import com.disney.explore.common.RoleEnum;
import com.disney.explore.common.converter.ConvertUtils;
import com.disney.explore.common.email.EmailHelper;
import com.disney.explore.common.email.template.RegisterTemplateEmail;
import com.disney.explore.domain.entity.User;
import com.disney.explore.domain.request.UserLoginRequest;
import com.disney.explore.domain.request.UserRegisterRequest;
import com.disney.explore.domain.response.UserAuthenticatedResponse;
import com.disney.explore.domain.response.UserCreatedResponse;
import com.disney.explore.exception.SendEmailException;
import com.disney.explore.exception.UserAlreadyRegisteredException;
import com.disney.explore.repository.IUserRepo;
import com.disney.explore.security.JwtService;
import com.disney.explore.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements IUserService, UserDetailsService {

    @Autowired
    private IUserRepo userRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private ConvertUtils convertUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private EmailHelper emailHelper;

    @Override
    @Transactional
    public UserCreatedResponse create(UserRegisterRequest userRegisterRequest)
        throws UserAlreadyRegisteredException, SendEmailException {
        if(userRepo.findByUsername(userRegisterRequest.getEmail()) != null) {
            throw new UserAlreadyRegisteredException("User already registered!!!");
        }
        User user = buildUser(userRegisterRequest);
        userRepo.save(user);
        sendEmail(userRegisterRequest.getEmail());
        return convertUtils.toUserCreatedResponse(user);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) {
        User user = userRepo.findByUsername(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found in database");
        }
        return user;
    }

    private User buildUser(UserRegisterRequest userRegisterRequest) {
        User user = new User();
        user.setEmail(userRegisterRequest.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(userRegisterRequest.getPassword()));
        user.setRole(RoleEnum.USER.getRoleName());
        return user;
    }

    @Override
    @Transactional
    public UserAuthenticatedResponse login(UserLoginRequest userLoginRequest) throws BadCredentialsException {
        try {
            UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(userLoginRequest.getEmail(), userLoginRequest.getPassword());
            authenticationManager.authenticate(authentication);
        } catch (Exception e) {
            throw new BadCredentialsException("Invalid username or password!!!", e);
        }
        UserDetails userDetails = loadUserByUsername(userLoginRequest.getEmail());
        String token = jwtService.createToken(userDetails);

        return convertUtils.toUserAuthenticatedResponse(userLoginRequest.getEmail(), token);
    }

    private void sendEmail(String emailTo) throws SendEmailException {
        try {
            emailHelper.sendMail(new RegisterTemplateEmail(emailTo));
        } catch (SendEmailException e) {
            throw new SendEmailException(e.getMessage());
        }

    }

}
