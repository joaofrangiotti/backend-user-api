package com.portfolio.apiusers.repository;

import com.portfolio.apiusers.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
