package com.example.user_api.service;

import com.example.user_api.model.User;
import com.example.user_api.model.Country;
import com.example.user_api.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getUsersByCountryExclusion(String countryName) {
        Country country = Country.valueOf(countryName.toUpperCase());
        return userRepository.findByCountryNotOrderByAgeAsc(country);
    }
}
