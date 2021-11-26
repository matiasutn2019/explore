package com.disney.explore.service.impl;

import com.disney.explore.common.converter.ConvertUtils;
import com.disney.explore.domain.entity.User;
import com.disney.explore.domain.entity.Role;
import com.disney.explore.domain.request.UserRequest;
import com.disney.explore.domain.response.UserResponse;
import com.disney.explore.repository.IUserRepo;
import com.disney.explore.service.IUserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

@Service
@Transactional
public class UserServiceImpl implements IUserService, UserDetailsService {

    @Autowired
    private IUserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ConvertUtils convertUtils;

    @Override
    public UserResponse create(UserRequest userRequest) {
        User user = buildUser(userRequest);
        userRepo.save(user);
        return convertUtils.toUserResponse(user);
        // falta la lógica de sendgrid
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        User user = userRepo.findByUsername(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found in database");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }
    private User buildUser(UserRequest userRequest) {
        User user = new User();
        user.setEmail(userRequest.getEmail());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        List<Role> roles = new ArrayList<>();
        userRequest.getRoles().forEach(role -> roles.add(role));
        user.setRoles(roles);
        return user;
    }
}
