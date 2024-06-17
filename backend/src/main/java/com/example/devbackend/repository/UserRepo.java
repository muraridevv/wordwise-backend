package com.example.devbackend.repository;

import com.example.devbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,String> {

    Optional<User> findByEmail(String email);

    Boolean existsByEmail(String email);
}
