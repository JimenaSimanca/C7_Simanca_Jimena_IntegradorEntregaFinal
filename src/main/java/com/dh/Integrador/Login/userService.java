package com.dh.Integrador.Login;

import com.dh.Integrador.Models.Security.User;
import com.dh.Integrador.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class userService implements UserDetailsService {
    private UserRepository userRepository;
    @Autowired
    public userService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userWanted= userRepository.findByUserName(username);

        if (userWanted.isPresent()){
            return userWanted.get();
        }
        else{
            throw new UsernameNotFoundException("El username ingresado no existe en la BD. Error.");
        }
    }
}
