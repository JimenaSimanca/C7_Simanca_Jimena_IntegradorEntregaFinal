package com.dh.Integrador.Login;

import com.dh.Integrador.Models.Security.User;
import com.dh.Integrador.Models.Security.UserRole;
import com.dh.Integrador.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private UserRepository userRepository;
    @Autowired
    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder= new BCryptPasswordEncoder();
        String passwordUserHash=passwordEncoder.encode("Leo93");
        User user =new User("Leonardo User","Leo93","leo@mail.com",passwordUserHash, UserRole.ROLE_USER);
        userRepository.save(user);

        String passwordAdminHash=passwordEncoder.encode("AdminLeo93");
        User admin =new User("Leonardo Admin","AdminLeo93","leoadmin@mail.com", passwordAdminHash, UserRole.ROLE_ADMIN);
        userRepository.save(admin);
    }




}
