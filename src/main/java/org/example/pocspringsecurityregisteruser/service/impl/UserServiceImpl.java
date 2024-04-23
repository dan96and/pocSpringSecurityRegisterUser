package org.example.pocspringsecurityregisteruser.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.pocspringsecurityregisteruser.domain.User;
import org.example.pocspringsecurityregisteruser.repository.UserRepository;
import org.example.pocspringsecurityregisteruser.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Override
    public Boolean createUser(User user) {
        String passwordEncode = passwordEncoder.encode(user.getPassword());
        user.setPassword(passwordEncode);
        user.setRole("USER");
        userRepository.save(user);
        return null;
    }
}
