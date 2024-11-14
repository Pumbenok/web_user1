package com.example.user_api.repository;

import com.example.user_api.model.User;
import com.example.user_api.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByCountryNotOrderByAgeAsc(Country country);
}
