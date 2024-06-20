package com.jusish.exam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jusish.exam.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
