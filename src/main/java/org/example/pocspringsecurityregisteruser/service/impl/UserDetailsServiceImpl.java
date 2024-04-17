package org.example.pocspringsecurityregisteruser.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.example.pocspringsecurityregisteruser.domain.User;
import org.example.pocspringsecurityregisteruser.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
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
        User user = userRepository.findByEmail(username);
        System.out.println("ESTOY AQUI");
        System.out.println("ESTOY AQUI");
        System.out.println("ESTOY AQUI");
        if (user == null) {
            System.out.println("Usuario o contraseña incorrectos");
        } else {
            System.out.println("El usuario es correcto");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        return buildUserForAuthentication(user, authorities);
    }

    public UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                authorities);
    }
}
