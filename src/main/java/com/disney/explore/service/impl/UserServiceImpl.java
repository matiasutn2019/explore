package com.disney.explore.service.impl;

import com.disney.explore.common.RoleEnum;
import com.disney.explore.common.converter.ConvertUtils;
import com.disney.explore.domain.entity.User;
import com.disney.explore.domain.request.UserLoginRequest;
import com.disney.explore.domain.request.UserRegisterRequest;
import com.disney.explore.domain.response.UserAuthenticatedResponse;
import com.disney.explore.domain.response.UserCreatedResponse;
import com.disney.explore.repository.IUserRepo;
import com.disney.explore.security.JwtService;
import com.disney.explore.service.IUserService;
import java.io.IOException;
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
@Transactional
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

    /*
    @Autowired
    private EmailHelper emailHelper;
    */

    @Override
    public UserCreatedResponse create(UserRegisterRequest userRegisterRequest)
        throws Exception {
        if(userRepo.findByUsername(userRegisterRequest.getEmail()) != null) {
            throw new Exception("User already registered!!!");
        }
        User user = buildUser(userRegisterRequest);
        userRepo.save(user);
        sendEmail(userRegisterRequest.getEmail());
        return convertUtils.toUserCreatedResponse(user);
    }

    @Override
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
    public UserAuthenticatedResponse login(UserLoginRequest userLoginRequest) throws Exception {
        try {
            UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(userLoginRequest.getEmail(), userLoginRequest.getPassword());
            authenticationManager.authenticate(authentication);
        } catch (BadCredentialsException e) {
            throw new Exception("Invalid username or password!!!", e);
        }
        UserDetails userDetails = loadUserByUsername(userLoginRequest.getEmail());
        String token = jwtService.createToken(userDetails);

        return convertUtils.toUserAuthenticatedResponse(userLoginRequest.getEmail(), token);
    }

    private void sendEmail(String email) throws IOException {
        //emailHelper.sendMail();
    }

}
