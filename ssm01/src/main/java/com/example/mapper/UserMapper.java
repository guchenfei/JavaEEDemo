package com.example.mapper;

import com.example.pojo.User;

import java.util.List;

public interface UserMapper {
    User findUser(String name, String password);

    List<User> findAllUser();
}
