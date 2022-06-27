package com.example.EgzaminoPavizdinisDarbas.service;

import com.example.EgzaminoPavizdinisDarbas.entity.User;

public interface UserService {

    User findUserFromDb(String username, String password);
}
