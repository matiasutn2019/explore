package com.disney.explore.service.impl;

import com.disney.explore.domain.entity.Role;
import com.disney.explore.repository.IRoleRepo;
import com.disney.explore.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleRepo roleRepo;

    @Override
    public Role findBy(String name) {
      return roleRepo.findByName(name);
   }
}
