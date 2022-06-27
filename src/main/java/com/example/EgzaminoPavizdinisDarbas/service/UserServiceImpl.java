package com.example.EgzaminoPavizdinisDarbas.service;


import com.example.EgzaminoPavizdinisDarbas.dao.UserRepository;
import com.example.EgzaminoPavizdinisDarbas.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserFromDb(String username, String password) {
        return userRepository.findUserByUserNameAndPassword(username, password);
    }
}
