package com.disney.explore.service;

import com.disney.explore.domain.AppUser;
import com.disney.explore.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepo userRepo;

    @Override
    public void registrarUser(AppUser user) throws Exception {
        userRepo.registrarUser(user);
    }

    @Override
    public AppUser findUserByUsername(AppUser user) {
        AppUser userFound = userRepo.findByUsername(user);
        return userFound;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
