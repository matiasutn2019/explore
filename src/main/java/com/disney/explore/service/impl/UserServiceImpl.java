package com.disney.explore.service.impl;

import com.disney.explore.common.EmailHelper;
import com.disney.explore.common.RoleEnum;
import com.disney.explore.common.converter.ConvertUtils;
import com.disney.explore.domain.entity.User;
import com.disney.explore.domain.entity.Role;
import com.disney.explore.domain.request.UserRegisterRequest;
import com.disney.explore.domain.response.UserResponse;
import com.disney.explore.repository.IUserRepo;
import com.disney.explore.service.IUserService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
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

    /*
    @Autowired
    private EmailHelper emailHelper;
    */

    @Override
    public UserResponse create(UserRegisterRequest userRegisterRequest) throws IOException {
        User user = buildUser(userRegisterRequest);
        userRepo.save(user);
        sendEmail(userRegisterRequest.getEmail());
        return convertUtils.toUserResponse(user);
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
        Role role = new Role();
        role.setName(RoleEnum.USER.getRoleName());
        user.setRole(role);
        return user;
    }

    private void sendEmail(String email) throws IOException {
        //emailHelper.sendMail();
    }
}
