package com.example.User.repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.User.model.User;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


public interface UserRepository extends JpaRepository<User, Integer>{
    Optional<User> findByUsername(String username);
    Optional<User> findByUsernameAndPassword(String username, String pass);
    List<User> findByUsernameIgnoreCaseContaining(String username);

}
