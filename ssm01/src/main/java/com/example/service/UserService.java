package com.example.service;

import com.example.pojo.User;

import java.util.List;

public interface UserService {
    User findUser(String name, String password);

    List<User> findAllUser();
}
