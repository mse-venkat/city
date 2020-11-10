package com.village.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.village.entity.Users;
import com.village.repository.UsersRepository;
import com.village.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(Users user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public Users findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}