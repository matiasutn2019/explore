package com.disney.explore.service.impl;

import com.disney.explore.common.RoleEnum;
import com.disney.explore.common.converter.ConvertUtils;
import com.disney.explore.domain.entity.User;
import com.disney.explore.domain.entity.Role;
import com.disney.explore.domain.request.UserRegisterRequest;
import com.disney.explore.domain.response.UserAuthenticatedResponse;
import com.disney.explore.repository.IUserRepo;
import com.disney.explore.service.IRoleService;
import com.disney.explore.service.IUserService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

    @Autowired
    private IRoleService roleService;

    /*
    @Autowired
    private EmailHelper emailHelper;
    */

    @Override
    public UserAuthenticatedResponse create(UserRegisterRequest userRegisterRequest)
        throws Exception {
        if(userRepo.findByUsername(userRegisterRequest.getEmail()) != null) {
            throw new Exception("User already registered!!!");
        }
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
        List<Role> roles = new ArrayList<>();
        roles.add(roleService.findBy(RoleEnum.USER.getRoleName()));
        user.setRoles(roles);
        return user;
    }

    private void sendEmail(String email) throws IOException {
        //emailHelper.sendMail();
    }
}
