package org.example.pocspringsecurityregisteruser.service.impl;

import org.example.pocspringsecurityregisteruser.domain.MyUserDetails;
import org.example.pocspringsecurityregisteruser.domain.User;
import org.example.pocspringsecurityregisteruser.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("EEEEEEEEEH");
        User user = userRepository.findByEmail(username);

        if (user == null) {
            System.out.println("Usuario o contraseña incorrectos");
            System.out.println("EEEEEEEEEH");
        } else {
            System.out.println("EEEEEEEEEH");
            System.out.println("El usuario es correcto");
            System.out.println("PASSWORD USER: "+user.getPassword());
        }
        return new MyUserDetails(user);
    }
}
