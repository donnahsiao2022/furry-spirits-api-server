package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {

    @Autowired
    IUserRepository userRepository;

    public User register(String name, String password) {

        User user;

        user = findApiUserBySystemId(name);
        if (user != null) {
            return null;
        }

        user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setCreateDatetime(new Date());

        userRepository.save(user);

        return user;
    }

    public User findApiUserBySystemId(String name) {
        return userRepository.findUserByName(name);
    }
}
