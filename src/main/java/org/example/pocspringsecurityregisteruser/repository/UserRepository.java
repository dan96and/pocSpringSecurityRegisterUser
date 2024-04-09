package org.example.pocspringsecurityregisteruser.repository;

import org.example.pocspringsecurityregisteruser.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
