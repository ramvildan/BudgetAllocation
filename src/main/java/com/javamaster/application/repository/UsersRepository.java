package com.javamaster.application.repository;

import com.javamaster.application.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Integer> {

    Users findByLogin(String login);

}
