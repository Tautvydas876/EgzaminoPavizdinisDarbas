package com.example.EgzaminoPavizdinisDarbas.dao;

import com.example.EgzaminoPavizdinisDarbas.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

    User findUserByUserNameAndPassword(String username, String password);
}
