package com.disney.explore.common;

import com.disney.explore.domain.entity.Role;
import com.disney.explore.domain.entity.User;
import com.disney.explore.repository.IRoleRepo;
import com.disney.explore.repository.IUserRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UsersSeeder implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception {

    }
}
